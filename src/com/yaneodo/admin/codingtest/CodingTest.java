package com.yaneodo.admin.codingtest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/codingtest/codingtest.do")
public class CodingTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//1. 데이터 확인 -> seq -> 관리자 로그인 확인
		
		//2. DB작업 -> select
		//3. 결과 처리
		
		
		//1. 로그인 확인
		
		
		//2.
		CodingtestDAO dao = new CodingtestDAO();
		
		ArrayList<CodingtestDTO> list = dao.getlist();

		
		
		req.setAttribute("list", list);

			
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/codingtest/codingtest.jsp");
		dispatcher.forward(req, resp);
	}
}
