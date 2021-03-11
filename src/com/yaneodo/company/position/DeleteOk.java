package com.yaneodo.company.position;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/position/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.
		req.setCharacterEncoding("UTF-8");
		
		String tempsession = "1"; //기업회원 번호
		String jseq = req.getParameter("jseq");
		
		
		PositionDAO dao = new PositionDAO();
		
		int result = 0;
		
		// 태그 정보 삭제
		result = dao.deletePositionTag(jseq);
		
		// 모집 공고 삭제
		result = dao.deletePosition(jseq);
		


		if (result > 0) {
			// 성공
			resp.sendRedirect("/yaneodo/company/position/list.do");
		} else {
			// 실패 -> 경고 + 뒤로가기
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