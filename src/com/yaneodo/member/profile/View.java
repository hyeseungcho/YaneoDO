package com.yaneodo.member.profile;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;
import com.yaneodo.member.resume.ResumeDAO;
import com.yaneodo.member.resume.ResumeDTO;


@WebServlet("/member/profile/view.do")
public class View extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//1. 데이터 가져오기(cseq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달
		
		HttpSession session = req.getSession();
		session.setAttribute("cseq", "1"); //일단 회원번호를 1로 고정
		
		//1.
		String cseq = (String)session.getAttribute("cseq"); //회원번호
		
		//2.
		ProfileDAO dao = new ProfileDAO();
		MemberDTO dto = dao.getProfile(cseq);
		
		ResumeDAO rdao = new ResumeDAO();
		ArrayList<ResumeDTO> rlist = rdao.list(cseq); //이력서목록정보 받아오기
		
		dao.close();//*****
		rdao.close();
		
	
		//3.
		req.setAttribute("dto", dto);
		req.setAttribute("rlist", rlist);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/profile/view.jsp");
		dispatcher.forward(req, resp);
	}

}
