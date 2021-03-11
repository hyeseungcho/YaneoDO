package com.yaneodo.company.match;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneodo.member.resume.ResumeDetailDTO;

/**
 * 사용자 정보의 ajax요청을 받는 서블릿
 * @author YSPark
 *
 */
@WebServlet("/company/match/customerdata.do")
public class CustomerData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// JSON 요청받기
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		String pseq = req.getParameter("pseq"); // 프로필 seq번호
		
		System.out.println("ResumeData pseq : " + pseq);
		
		
		MatchDAO mdao = new MatchDAO();
		// pseq 로 한명의 프로필 데이터를 받아와야 함
		ResumeDetailDTO pdto = mdao.getResumeDetail(pseq);
		
		
		
		
		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		
		temp += "{";
        temp += String.format("\"name\":\"%s\",", pdto.getName());
        temp += String.format("\"email\":\"%s\",", pdto.getEmail());
        temp += String.format("\"phone\":\"%s\",", pdto.getPhone());
        temp += String.format("\"intro\":\"%s\"", pdto.getIntroduction());
        temp += "}";
        
        writer.print(temp);
	      
	    writer.close();
		
	}

}
