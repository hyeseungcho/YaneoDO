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
import com.yaneodo.member.MemberDTO;

@WebServlet("/member/myyaneodo/changepw.do")
public class ChangePW extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String seq = (String)session.getAttribute("seq");
		String password = (String)session.getAttribute("password");
		String pw = req.getParameter("nowPassword");
		String npw = req.getParameter("checkPassword");
		MemberDAO dao = new MemberDAO(); 
		MemberDTO dto = new MemberDTO();
		dto.setCustomerSeq(seq);
		dto.setPassword(pw);
		dto.setNewpw(npw);
		
		int result = dao.checkPW(dto);
		
		if(result==1) {
			resp.sendRedirect("/yaneodo/member/myyaneodo/myyaneodo.do");
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer=resp.getWriter();
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('비밀번호를 잘못 입력하셨습니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();

			
		}

	}
}

