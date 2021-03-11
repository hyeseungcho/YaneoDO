package com.yaneodo.company.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/main/joincheck.do")
public class JoinCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//Ajax 응답 처리 페이지

		//1. 데이터 가져오기 (ajax -> id)
		//2. DB 작업 -> select
		//3. 결과 반환
		
		//1.
		String email = req.getParameter("email");
		
		
		
		
		//2.
		
		System.out.println(email);
		
		CompanyDAO dao = new CompanyDAO();
		int result = dao.checkId(email);
		
		System.out.println(result);
		
		
		//3. 
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		writer.close();


	}
}
