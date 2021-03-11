package com.yaneodo.community.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/community/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//목록 or 검색
		// - 목록: list.do
		// - 검색: list.do?search=게시판

		HashMap<String,String> map = new HashMap<String,String>();
	      
		String search = req.getParameter("search");
	      
		if (!(search == null || search.equals(""))) {
	         map.put("search", search);
		}

	    
		
		//1. DB 작업 > select
		//2. 목록 반환 + JSP 전달&호출하기
		
		
		HttpSession session = req.getSession();
	
		
		
		//1.
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list(map);
		
		//데이터 조작 -> 서블릿 담당
		//데이터 출력 -> JSP 담당
		
		//1.1 데이터 조작
		for (BoardDTO dto : list) {
			
			//날짜에서 시간 잘라내기
			dto.setWriteDate(dto.getWriteDate().substring(0, 10));
			
			//제목이 너무 길면 자르기
			if (dto.getTitle().length() > 30) {
				dto.setTitle(dto.getTitle().substring(0, 30) + "...");
			}
		}
		
		
		//2.
		req.setAttribute("list", list);
//		req.setAttribute("search", search); //검색어전달
//		req.setAttribute("pagebar", pagebar); //페이지바
//		req.setAttribute("nowPage", nowPage); //현재페이지


		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}
