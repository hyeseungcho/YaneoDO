package com.yaneodo.admin.gain;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/gain/gain_company_search.do")
public class Gain_company_Search extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1.데이터 가져오기
		//2.DB작업 -> select
		//3.결과 처리
		
		req.setCharacterEncoding("UTF-8");
		//1.
		
		String name = req.getParameter("searchname");//검색한 기업회원이름
		
		GainCompanyDAO dao = new GainCompanyDAO();
		
		
		//2.
		ArrayList<GainCompanyDTO> list = dao.getGainCompany(name); 
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/gain/gain_company.jsp");
		dispatcher.forward(req, resp);
	}
}
