package com.cos.fruit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.fruit.action.Action;
import com.cos.fruit.action.ProductDeleteProcAction;
import com.cos.fruit.action.ProductFirstProcAction;
import com.cos.fruit.action.ProductHomeAction;
import com.cos.fruit.action.ProductPriceSortProcAction;
import com.cos.fruit.action.ProductSellSortProcAction;



@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final String TAG ="ProductController : ";
	private static final long serialVersionUID = 1L;
       
  
    public ProductController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
		
	}


	public Action router(String cmd) {
		if(cmd.equals("home")) {
			// Home 페이지로 이동
			return new ProductHomeAction(); //Board 의 목록
		}else if(cmd.equals("first")) {
			return new ProductFirstProcAction();
		}else if(cmd.equals("priceSort")) {
			return new ProductPriceSortProcAction();
		}else if(cmd.equals("countSort")) {
			return new ProductSellSortProcAction();
		}else if(cmd.equals("deleteProc")) {
			return new ProductDeleteProcAction();
		}
		return null;
	}
}
