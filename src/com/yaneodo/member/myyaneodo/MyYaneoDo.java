package com.yaneodo.member.myyaneodo;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.status.StatusDAO;
import com.yaneodo.member.status.StatusDTO;

@WebServlet("/member/myyaneodo/myyaneodo.do")
public class MyYaneoDo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String seq = (String)session.getAttribute("seq");
		StatusDAO dao = new StatusDAO();
		int cntComplete = dao.cntComplete(seq);
		int cntFail = dao.cntFail(seq);
		int cntPass = dao.cntPass(seq);
		int cntResumePass = dao.cntResumePass(seq);
		int match = dao.matchCount(seq);
		int read = dao.readCount(seq);
		int want = dao.wantedCount(seq);
		//req.setAttribute("photo", photo);
		req.setAttribute("cntComplete", cntComplete);
		req.setAttribute("cntFail", cntFail);
		req.setAttribute("cntPass", cntPass);
		req.setAttribute("cntResumePass", cntResumePass);
		req.setAttribute("match", match);
		req.setAttribute("read", read);
		req.setAttribute("want", want);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/myyaneodo/myyaneodo.jsp");
		dispatcher.forward(req, resp);
	}

}
