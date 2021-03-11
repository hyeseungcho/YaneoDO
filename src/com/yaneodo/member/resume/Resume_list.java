package com.yaneodo.member.resume;

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

@WebServlet("/member/resume/resume_list.do")
public class Resume_list extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = (String)session.getAttribute("seq");
		
		MemberDAO dao2 = new MemberDAO();
		ResumeDAO dao = new ResumeDAO();
		
		MemberDTO dto2 = dao2.get(seq);
		ArrayList<ResumeDTO> list = dao.list(seq);
		
		
		req.setAttribute("list", list);
		req.setAttribute("rseq", dto2.getResumeSeq());
		req.setAttribute("name", dto2.getName());
		req.setAttribute("email",dto2.getEmail());
		req.setAttribute("phone", dto2.getPhone());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/resume/resume_list.jsp");
		dispatcher.forward(req, resp);

	}
}
