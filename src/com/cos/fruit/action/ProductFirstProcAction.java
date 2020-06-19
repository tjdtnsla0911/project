package com.cos.fruit.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.fruit.model.Product;
import com.cos.fruit.repository.ProductRepository;
import com.cos.fruit.util.Script;
import com.google.gson.Gson;

public class ProductFirstProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepository productRepository = ProductRepository.getInstance();

		List<Product> products = productRepository.findAll();

		//request.setAttribute("products", products);

		Gson gson = new Gson();
		String productsJson = gson.toJson(products);
		System.out.println(productsJson+" <-- 파싱한 내용 데스네");
		Script.outJson(productsJson, response);

		//Script.outText(products+"", response);

	}
}