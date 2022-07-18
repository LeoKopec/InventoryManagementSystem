package com.skillstorm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.doas.MySQLShipmentDOAImpl;
import com.skillstorm.doas.ShipmentDOA;
import com.skillstorm.models.Shipment;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/warehouseshipments/*")
public class WarehouseShipmentsServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private static final long serialVersionUID = -3452327219382400563L;
	ShipmentDOA doa = new MySQLShipmentDOAImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int warehouseNum = urlService.extractNumFromURL(req.getPathInfo());
			// This means they want a specific artist. Find that artist
			List<Shipment> shipments = doa.findByWarehouse(warehouseNum);
			if (shipments != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(shipments));
			} else {
				resp.setStatus(404);
				resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("Item not found")));
			} 
		} catch (Exception e) {
			List<Shipment> shipments = doa.findAll();
			System.out.println(shipments);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(shipments));
		}
	}
	
}
