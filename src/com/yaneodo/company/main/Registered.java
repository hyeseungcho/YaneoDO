package com.yaneodo.company.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/company/main/registered.do")
public class Registered extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String cmseq = (String)session.getAttribute("cmseq");
		//System.out.println(session.getAttribute("cmseq"));
		
		CompanyDAO dao = new CompanyDAO();	
		CompanyDTO dto = dao.getCompany(cmseq);
		
		//req.setAttribute("cmseq", cmseq);
		req.setAttribute("dto", dto);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/main/register.jsp");
		dispatcher.forward(req, resp);

	}
}
