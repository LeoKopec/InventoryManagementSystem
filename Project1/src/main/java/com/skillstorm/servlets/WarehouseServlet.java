package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.doas.MySQLWarehouseDOAImpl;
import com.skillstorm.doas.WarehouseDOA;
import com.skillstorm.models.Warehouse;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/warehouses/*")
public class WarehouseServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private static final long serialVersionUID = -1255978588645665829L;
	WarehouseDOA doa = new MySQLWarehouseDOAImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int warehouseNum = urlService.extractNumFromURL(req.getPathInfo());
			Warehouse warehouse = doa.findByNum(warehouseNum);
			if (warehouse != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(warehouse));
			} else {
				resp.setStatus(404);
				resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("Warehouse not found")));
			}
		} catch (Exception e) {
			List<Warehouse> warehouses = doa.findAll();
			System.out.println(warehouses);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(warehouses));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Warehouse newWarehouse = mapper.readValue(reqBody,Warehouse.class);
		doa.save(newWarehouse); 
		if (newWarehouse != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(newWarehouse));
			resp.setStatus(201); //The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound()));
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Warehouse changedWarehouse = mapper.readValue(reqBody, Warehouse.class);
		doa.updateCurrentCapacity(changedWarehouse); 
		if (changedWarehouse != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(changedWarehouse));
			resp.setStatus(201); //The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound()));
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
		int warehouseNum = urlService.extractNumFromURL(req.getPathInfo());
		if (warehouseNum > 0) {
			doa.deleteByNum(warehouseNum);
			resp.setStatus(200);
		}
		else {
			resp.setStatus(400);
		}
	}

}
