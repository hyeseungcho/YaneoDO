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


@WebServlet("/admin/member/member.do")
public class Member extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		//1. 데이터 가져오기(customerSeq, page)
		String seq = req.getParameter("customerseq");
		String page = req.getParameter("page");
		
		//2. DB 작업 -> select
		MemberDAO dao = new MemberDAO();
		MemberDTO memberdto = dao.member(seq);
		ArrayList<MemberDTO> resumeList = dao.resume(seq);
		
		memberdto.setJoinDate(memberdto.getJoinDate().substring(0, 10));
		memberdto.setLastJoin(memberdto.getLastJoin().substring(0, 10));
		
		dao.close();
		
		//3. 결과 반환
		req.setAttribute("memberdto", memberdto);
		req.setAttribute("resumeList", resumeList);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/member/member.jsp");
		dispatcher.forward(req, resp);

	}

}