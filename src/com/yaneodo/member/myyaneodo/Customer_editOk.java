package com.yaneodo.member.myyaneodo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;

@WebServlet("/member/myyaneodo/customer_editok.do")
public class Customer_editOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		//수정데이터가져오기
		//String seq = (String)session.getAttribute("seq");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String birth = req.getParameter("birth");
		String nickName = req.getParameter("nickName");
//		String seq = req.getParameter("1");
		
		//가져온데이터담기
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setPhone(phone);
		dto.setBirth(birth);
		dto.setNickName(nickName);
//		dto.setSeq("1");
		MemberDAO dao = new MemberDAO();
		

		
		//수정처리
		
		int result = dao.edit(dto,(String)session.getAttribute("seq"));
		
		
		//결과처리
		if(result==1) {
			resp.sendRedirect("/yaneodo/member/myyaneodo/myyaneodo.do");
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer=resp.getWriter();
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('수정에 실패하였습니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();

			
		}
		
		
	}
}

