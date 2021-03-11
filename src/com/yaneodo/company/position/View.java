package com.yaneodo.company.position;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/position/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 1. 데이터 받아오기 
		// 2. DB 접근해서 모집공고 정보 가져오기
		// 3. JSP 페이지에 전달
		
		
		//1.
		
		String jseq = req.getParameter("jseq"); // jobOpenningSeq 공고번호
		System.out.println("jseq : " + jseq);
		
		
		//2.
		PositionDAO pdao = new PositionDAO();
		
		// 공고 번호의 공고 데이터를 DTO에 담음
		JobOpeningDTO pdto = pdao.getPositionView(jseq); 
		
		
		// 공고의 태그 리스트를 가져온다
		ArrayList<TagDTO> taglist = pdao.getTagList(pdto.getJobopeningseq());
		
		
		
		
		
		//3. 
		
		req.setAttribute("pdto", pdto);
		req.setAttribute("jseq", jseq);
		req.setAttribute("taglist", taglist);
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/position/view.jsp");
		dispatcher.forward(req, resp);
	}

}