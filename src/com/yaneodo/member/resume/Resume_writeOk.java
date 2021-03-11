package com.yaneodo.member.resume;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;

@WebServlet("/member/resume/resume_writeok.do")
public class Resume_writeOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

HttpSession session = req.getSession();
//req.setCharacterEncoding("UTF-8");
		String seq = (String)(session.getAttribute("seq"));
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.get(seq);
		ResumeDAO dao2 = new ResumeDAO();
		String num = dao2.num(seq);
		String rseq = dao2.newResume(seq);
		
		int result = dao2.resumeWrite(dto,seq,num);
		
		if(result ==1) {
		
		resp.sendRedirect("/yaneodo/member/resume/resume_write.do?rseq=" +rseq);
		
		}
		
		else {
		PrintWriter writer = resp.getWriter();
			resp.setCharacterEncoding("UTF-8");
			writer.print("<html><head><meta charset='utf-8'></head>body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
	}
}

