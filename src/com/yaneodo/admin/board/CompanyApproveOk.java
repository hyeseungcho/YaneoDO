package com.yaneodo.admin.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/company/companyapproveok.do")
public class CompanyApproveOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//3. 결과 처리
		
		HttpSession session = req.getSession();
		
		
		//1. 데이터 가져오기(companyseq)
		req.setCharacterEncoding("UTF-8");
		
		String seq = req.getParameter("companyseq");
		
		//2. DB 작업 > update
		CompanyDAO dao = new CompanyDAO();
		CompanyDTO dto = new CompanyDTO();
		
		dto.setState("1");
		dto.setCompanySeq(seq);
		
		int result = dao.editState(dto);
		
		if (result == 1) {

			//글수정 성공 -> 글보기로 이동(view.do)
			resp.sendRedirect("/yaneodo/admin/company/companyapprovelist.do");
			
		} else {
			//글수정 실패 -> 경고 + 뒤로 가기
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







