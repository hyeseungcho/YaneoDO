package com.yaneodo.admin.codingtest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/codingtest/codingtestquestion.do")
public class CodingTestQuestion extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	

			
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/codingtest/codingtestquestiontest.jsp");
		dispatcher.forward(req, resp);
	}
}
