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

@WebServlet("/admin/company/company.do")
public class Company extends HttpServlet {

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
		ArrayList<CompanyDTO> jobopeningList = dao.jobOpening(seq);
		
		companydto.setEstablishment(companydto.getEstablishment().substring(0, 10));
		
		for (CompanyDTO jobopeningdto : jobopeningList) {
			
			//날짜에서 시간 잘라내기
			jobopeningdto.setStartDate(jobopeningdto.getStartDate().substring(0, 10));
			jobopeningdto.setEndDate(jobopeningdto.getEndDate().substring(0, 10));

		}
		
		dao.close();
		
		//3. 결과 반환
		req.setAttribute("companydto", companydto);
		req.setAttribute("jobopeningList", jobopeningList);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/company/company.jsp");
		dispatcher.forward(req, resp);

	}

}