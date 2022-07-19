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

@WebServlet(urlPatterns = "/allshipments/*")
public class AllShipmentsServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private static final long serialVersionUID = -2631307842120474573L;
	ShipmentDOA doa = new MySQLShipmentDOAImpl();
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Shipment> shipments = doa.findAll();
		System.out.println(shipments);
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(shipments));
	}
	
}
