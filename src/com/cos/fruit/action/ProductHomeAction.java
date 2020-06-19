package com.cos.fruit.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.fruit.model.Product;
import com.cos.fruit.repository.ProductRepository;

public class ProductHomeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> products = productRepository.findAll();
		
		request.setAttribute("products", products);
		
		// 3. 이동 home.jsp
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
	}
}
