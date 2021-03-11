package com.yaneodo.company.position;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneodo.company.match.MatchDAO;

@WebServlet("/company/position/edit.do")
public class edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 데이터 받아오기 
		// 2. DB 접근해서 모집공고 정보 가져오기
		// 3. JSP 페이지에 전달
		
		//1.
		String jseq = req.getParameter("jseq"); // jobOpenningSeq 공고번호
		System.out.println("jseq : " + jseq);
		
		//2. DB 접속 Select 로 
		MatchDAO mdao = new MatchDAO();
		PositionDAO pdao = new PositionDAO();
		
		ArrayList<String> jlist = mdao.listJob(); // 직무목록
		
		ArrayList<TagCategoryDTO> tclist = pdao.listTagCategory(); //태그 카테고리 목록
		
		// 공고 번호의 공고 데이터를 DTO에 담음
		JobOpeningDTO pdto = pdao.getPositionView(jseq); 
		
		
		// 공고의 태그 리스트를 가져온다
		ArrayList<TagDTO> taglist = pdao.getTagList(pdto.getJobopeningseq());
		
		
		//3. 
		req.setAttribute("jlist", jlist); // 직무 목록
		req.setAttribute("tclist", tclist); // 태그 카테고리 목록
		
		req.setAttribute("pdto", pdto); // 공고 정보
		req.setAttribute("jseq", jseq); // 공고번호
		req.setAttribute("taglist", taglist); // 공고의 태그 리스트
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/position/edit.jsp");
		dispatcher.forward(req, resp);
	}

}
