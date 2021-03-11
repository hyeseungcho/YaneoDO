package com.yaneodo.company.position;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/position/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. DB에서 Select
		// 2. jsp 페이지에 전달
		
		String tempsession = "1"; // 기업회원 임의 세션
			
		// 1.
		PositionDAO dao = new PositionDAO();
		// 모집공고 리스트
		ArrayList<JobOpeningDTO> list = dao.getPositionList(tempsession);
		
		
		
		// 2.
		
		req.setAttribute("list", list);
		
		
		
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/position/list.jsp");
		dispatcher.forward(req, resp);
	}

}