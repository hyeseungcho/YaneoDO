package com.yaneodo.admin.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/company/companyapprove.do")
public class CompanyApprove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		//1. 데이터 가져오기(customerSeq, page)
		String seq = req.getParameter("companyseq");
		String page = req.getParameter("page");
		
		//2. DB 작업 -> select
		CompanyDAO dao = new CompanyDAO();
		CompanyDTO companydto = dao.company(seq);
		
			
		companydto.setEstablishment(companydto.getEstablishment().substring(0, 10));
		
		
		dao.close();
		
		//3. 결과 반환
		req.setAttribute("companydto", companydto);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/company/companyapprove.jsp");
		dispatcher.forward(req, resp);

	}

}