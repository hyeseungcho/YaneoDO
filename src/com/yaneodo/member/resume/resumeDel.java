package com.yaneodo.member.resume;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/resume/resumedel.do")
public class resumeDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String seq = (String)session.getAttribute("seq");
	String rseq = req.getParameter("rseq");
	ResumeDAO dao = new ResumeDAO();

	/*
	 * dao.rabroadDelete(rseq); dao.rawardDelete(rseq);
	 * dao.rcertificateDelete(rseq); dao.reducationDelete(rseq);
	 * dao.rexperienceDelete(rseq); dao.rlanguageDelete(rseq);
	 * dao.rportfolioDelete(rseq); dao.rtrainingDelete(rseq);
	 */
	
		dao.profilenull(rseq);

		int result = dao.resumeDelete(rseq);
		if(result==1) {
			resp.sendRedirect("/yaneodo/member/resume/resume_list.do?seq="+seq);	
		} else {
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer=resp.getWriter();
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('삭제에 실패하였습니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
		
	
	}
	
}

