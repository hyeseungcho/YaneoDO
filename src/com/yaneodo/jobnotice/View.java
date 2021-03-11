package com.yaneodo.jobnotice;

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



@WebServlet("/jobnotice/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//서블릿에서 세션을 접근하는 방법
		HttpSession session = req.getSession();
		
		//session.setAttribute("login", true);
//		session.setAttribute("id", dto.getId()); //인증 티켓
		
		session.setAttribute("cseq", "1"); //일단 회원번호를 1로 고정
		
		//사이트 전역을 계속 들고 다녀야 하는 정보가 있으면 -> 세션에 추가
		//나머지 회원 정보 -> select
//		MemberDTO rdto = dao.getMember(id);
//		
//		session.setAttribute("name", rdto.getName());
//		session.setAttribute("pic", rdto.getPic());
//		session.setAttribute("regdate", rdto.getRegdate());
//		session.setAttribute("seq", rdto.getSeq());
//		session.setAttribute("email", rdto.getEmail());
//		
		
		
		
		
		
		
		//1. 데이터 가져오기(seq) : 공고번호
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달


		//1.
		String cseq = (String)session.getAttribute("cseq"); //회원번호
		String seq = req.getParameter("seq"); //선택한 공고번호
				
		
		//2.
		JobNoticeDAO jdao = new JobNoticeDAO();
		JobNoticeDTO jdto = jdao.get(seq); //공고 정보 받아오기

		MemberDAO mdao = new MemberDAO(); 
		MemberDTO mdto = mdao.get(cseq); //회원 정보 받아오기
		
		ResumeDAO rdao = new ResumeDAO();
		ArrayList<ResumeDTO> rlist = rdao.list(cseq); //이력서목록정보 받아오기
		

		
		jdao.close();
		mdao.close();
		rdao.close();

		
		//2.1 데이터 조작
		//개행 문자 출력하기
		jdto.setDescription(jdto.getDescription().replace("\r\n", "<br>"));

		
		
		//3.
		req.setAttribute("jdto", jdto);
		req.setAttribute("mdto", mdto);
		req.setAttribute("rlist", rlist);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/jobnotice/view.jsp");
		dispatcher.forward(req, resp);
	}

}