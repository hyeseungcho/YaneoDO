package com.yaneodo.company.match;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/match/resumedetailok.do")
public class ResumeDetailOK extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String tempsession = "1";
		String pseq = req.getParameter("pseq");
		
		System.out.println("ResumeDetailOK data resq : " + pseq);
		
		PrintWriter writer = resp.getWriter();
		String returnNum = "";
		
		
		MatchDAO mdao = new MatchDAO();
		// 열람권 개수 확인 
		String count = mdao.getPassCount(tempsession);
		
		System.out.println("열람권 개수 : " + count);
		int passCount = Integer.parseInt(count);
		
		
		if (passCount > 0) {
			// 0이 아닐때 정상적으로 처리
			// 열람권 -1 UPDATE
			mdao.updatePassCount(tempsession);
			
			// 매치업 테이블에 INSERT
			mdao.AddResumeRead(tempsession, pseq);
			
			returnNum = "1";
			
		} else {
			// 열람권이 0일때 이후 동작하지 않음
			
			returnNum = "2";
			
			
		}
		
		
		writer.print(returnNum);
	      
	    writer.close();

	}

}
