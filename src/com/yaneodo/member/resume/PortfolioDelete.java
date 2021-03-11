package com.yaneodo.member.resume;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/resume/portfoliodelete.do")
public class PortfolioDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("poseq");
		String rseq = req.getParameter("rseq");
		ResumeDAO dao = new ResumeDAO();
		
		int result = dao.portfolioDelete(seq);
		
		if(result ==1) {

			resp.sendRedirect("/yaneodo/member/resume/resume_write.do?rseq="+rseq);
			
		} else {
			//글쓰기 실패 -> 경고 + 뒤로가기
		PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
		

	}
}

