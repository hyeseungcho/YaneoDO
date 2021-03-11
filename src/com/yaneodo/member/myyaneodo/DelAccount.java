package com.yaneodo.member.myyaneodo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;

@WebServlet("/member/myyaneodo/delaccount.do")
public class DelAccount extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = (String)session.getAttribute("seq");
		
		MemberDAO dao = new MemberDAO(); 
				
		int result = dao.delaccount(seq);
		
		if(result==1) {
	
			session.invalidate();
			
			resp.sendRedirect("/yaneodo/index.do");

		} else {
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer=resp.getWriter();
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('실패하였습니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();

			
		}

		
		

	}
}

