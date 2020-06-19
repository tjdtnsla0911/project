package com.cos.fruit.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void outText(String msg, HttpServletResponse response) {

		try {

			//
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain; charset=utf-8");

			// 버퍼를 달아서 
			PrintWriter out = response.getWriter();
			out.print(msg);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void outJson(String msg, HttpServletResponse response) {

		try {

			//
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");

			// 버퍼를 달아서 
			PrintWriter out = response.getWriter();
			out.print(msg);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
