package com.yaneodo.company.match;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/match/dibsaddok.do")
public class DibsAddOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 받아온 데이터 (profileseq)
		//2. DB 처리 -> tblDibs에 INSERT
		//3. jsp 페이지로 상태유지 데이터 전달
		
		//1. 
		
		String tempSession = "1"; // 기업회원번호 임의 세션
		String pseq = req.getParameter("pseq"); // 프로필번호
		System.out.println("pseq" + pseq);
		
		String search = req.getParameter("search"); // 검색어
		String jobtype = req.getParameter("jobtype"); // 직무 select
		String isdibs = req.getParameter("isdibs"); // 찜목록
		String isread = req.getParameter("isread"); // 1 : 열람 or 0 : 미열람
		String ismatch = req.getParameter("ismatch"); // 면접제안
		String page = req.getParameter("page"); // 페이지
		
		
		
		
		//2.
		MatchDAO mdao = new MatchDAO();
		int result = mdao.addDibs(pseq, tempSession);
		
		
		
		
		
		//3.
		
		if (result == 1) {
			//찜하기 성공
			resp.sendRedirect("/yaneodo/company/match/list.do?isdibs=" +isdibs+"&search=" + search+"&jobtype=" + jobtype+"&isread=" + isread+"&ismatch=" + ismatch+"&page=" + page);
			
			
		} else {
			//찜하기 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('찜하기 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
	}

}