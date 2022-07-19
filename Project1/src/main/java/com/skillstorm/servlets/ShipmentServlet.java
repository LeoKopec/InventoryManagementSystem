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
import com.skillstorm.doas.MySQLShipmentDOAImpl;
import com.skillstorm.doas.ShipmentDOA;
import com.skillstorm.models.Shipment;
import com.skillstorm.models.Warehouse;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/shipments/*")
public class ShipmentServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private static final long serialVersionUID = -3003238811085999676L;
	ShipmentDOA doa = new MySQLShipmentDOAImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int crate = urlService.extractNumFromURL(req.getPathInfo());
			// This means they want a specific artist. Find that artist
			Shipment shipment = doa.findByCrate(crate);
			if (shipment != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(shipment));
			} else {
				resp.setStatus(404);
				resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("Item not found")));
			}
		} catch (NumberFormatException e) {
			try {
				String name = urlService.extractNameFromURL(req.getPathInfo());
				// This means they want a specific artist. Find that artist
				List<Shipment> shipmentsByName = doa.findByItems(name);
				if (shipmentsByName != null) {
					resp.setContentType("application/json");
					resp.getWriter().print(mapper.writeValueAsString(shipmentsByName));
				} else {
					resp.setStatus(404);
					resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("Item not found")));
				} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Shipment newShipment = mapper.readValue(reqBody, Shipment.class);
		doa.save(newShipment); 
		if (newShipment != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(newShipment));
			resp.setStatus(201); //The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound()));
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int crate = urlService.extractNumFromURL(req.getPathInfo());
		if (crate > 0) {
			doa.deleteByCrate(crate);
			resp.setStatus(200);
		}
		else {
			resp.setStatus(400);
		}
	}
	
}
