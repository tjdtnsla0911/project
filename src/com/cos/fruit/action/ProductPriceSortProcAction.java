package com.cos.fruit.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.fruit.model.Product;
import com.cos.fruit.repository.ProductRepository;
import com.cos.fruit.util.Script;
import com.google.gson.Gson;

public class ProductPriceSortProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> products = productRepository.PriceSortfindAll();
		
		//request.setAttribute("products", products);
		
		Gson gson = new Gson();
		// 3. 이동 home.jsp
		String productsJson = gson.toJson(products);
		Script.outJson(productsJson, response);
		
		//Script.outText(products+"", response);
		
	}
}
