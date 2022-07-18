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

import com.skillstorm.doas.ItemDOA;
import com.skillstorm.doas.MySQLItemImpl;
import com.skillstorm.models.Item;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/items/*")
public class ItemServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	private static final long serialVersionUID = -954487132744010736L;
	ItemDOA doa = new MySQLItemImpl();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = urlService.extractNameFromURL(req.getPathInfo());
			// This means they want a specific artist. Find that artist
			Item item = doa.findByName(name);
			if (item != null) {
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(item));
			} else {
				resp.setStatus(404);
				resp.getWriter().print(mapper.writeValueAsString(new IllegalArgumentException("Item not found")));
			}
		} catch (Exception e) {
			// Means that there wasn't an id in the URL. Fetch all artists instead
			List<Item> items = doa.findAll();
			System.out.println(items);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(items));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		double price = Double.parseDouble(req.getParameter("pricePerPound"));
//		String name = req.getParameter("itemName");
		
		InputStream reqBody = req.getInputStream();
		Item newItem = mapper.readValue(reqBody, Item.class);
		doa.save(newItem); 
		if (newItem != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(newItem));
			resp.setStatus(201); //The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound()));
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream reqBody = req.getInputStream();
		Item changedItem = mapper.readValue(reqBody, Item.class);
		doa.updatePrice(changedItem); 
		if (changedItem != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(changedItem));
			resp.setStatus(201); //The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(mapper.writeValueAsString(new NotFound()));
		}
	}


}
