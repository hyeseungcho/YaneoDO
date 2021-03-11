package com.yaneodo.community.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/community/board/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달
		
		HttpSession session = req.getSession();
		
		//1.
		String seq = req.getParameter("seq");
//		String search = req.getParameter("search");
//		String page = req.getParameter("page"); 
		
		//2.
		BoardDAO dao = new BoardDAO();
		

		//2.1 조회수 증가
		//새로고침에 의한 증가 방지 
//		if (session.getAttribute("read") == null || (boolean)session.getAttribute("read") == false) { //북마크로진입 || list페이지에서 진입
//			dao.updateReadcount(seq);
//			session.setAttribute("read", true);
//		}
//		
		BoardDTO dto = dao.get(seq);
		
		
		//댓글 목록 가져오기
		//현재 보고 있는 글에 달려있는 댓글 목록 가져오기 
//		ArrayList<CommentDTO> clist = dao.listComment(seq); 


		dao.close();//*****
		
		//2.2 데이터 조작
		//개행 문자 출력하기
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		
		
		
		//3.
		req.setAttribute("dto", dto);
//		req.setAttribute("search", search);
//		req.setAttribute("page", page);
//		req.setAttribute("clist", clist); //댓글
		
		
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/board/view.jsp");
		dispatcher.forward(req, resp);
	}

}