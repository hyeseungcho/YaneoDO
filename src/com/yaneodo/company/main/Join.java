package com.yaneodo.company.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/main/join.do")
public class Join extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String managerName = req.getParameter("managerName");
		String managerPhone = req.getParameter("managerPhone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		CmemberDAO dao = new CmemberDAO();
		CmemberDTO dto = new CmemberDTO();
		
		dto.setManagerName(managerName);
		dto.setManagerPhone(managerPhone);
		dto.setEmail(email);
		dto.setPassword(password);
				
		int result = dao.join(dto);
		
		if (result == 1) {
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('회원가입이 완료되었습니다.');");
			writer.print("location.href='/yaneodo/company/main/index.do';");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			//resp.sendRedirect("/yaneodo/company/main/index.do");
			
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('회원가입에 실패했습니다. 고객센터로 문의바랍니다.');");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		
		}

	}
}
