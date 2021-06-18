package com.skillstorm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.models.Category;
import com.skillstorm.models.Product;

@WebServlet(urlPatterns = "/products") // , loadOnStartup = 1)
@WebInitParam(name = "dan", value = "Hello World")
// normally, servlet is instantiated/initialized when 1st invoked
public class ProductServlet extends HttpServlet {

	// HttpServlet -> GenericServlet -> Servlet (interface) init/service/destroy

	public ProductServlet() {
		// create an instance
		System.out.println("Instantiating ProductServlet");
	}

	@Override
	public void init() throws ServletException {
		// initialize the state, configuring, etc.
		System.out.println("ProductServlet - Init(): " + this.getInitParameter("dan"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// pretend to hit the database
		Map<Integer, Product> database = new HashMap<>();
		database.put(1,
				new Product(1, "Pickles", "Jarred pickled cucumbers", 3.99, new Category(1, "Vegetables", true)));
		database.put(2, new Product(2, "Bread", "wheat bread", 1.99, new Category(2, "Baked Goods", true)));
		database.put(3, new Product(3, "<script>window.alert('hackerz');</script>",
				"<script>window.alert('hackerz!!!');</script>", 5.99, new Category(2, "Baked Goods", true)));

		Product prod = new Product().new Builder().id(4).name("Milk").price(4.99).categoryName("Dairy").build();
		database.put(4, prod);
		
		// store the data in request // product_list is c:forEach items
		req.setAttribute("product_list", database.values());

		PrintWriter out = resp.getWriter();

//		out.print("<html><body>"
//				+ variable + "</body></html>");

		// forward the user to the products page
		req.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(req, resp);
	}

}
