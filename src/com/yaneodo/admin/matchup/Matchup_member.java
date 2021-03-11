package com.yaneodo.admin.matchup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/matchup/matchup_member.do")
public class Matchup_member extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//
		
		//2. DB작업
		
		//3. 결과 출력
		
		//2.
		
		//2-1 회원의 총 목록수 가져오기
		MatchupDAO dao = new MatchupDAO();
		
		int all = dao.getcount();
		
		
		
		//2-2 회원의 매치업 정보 가져오기
		
		
		ArrayList<MatchupDTO> list = dao.getmemberlist(all);
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/matchup/matchup_member.jsp");
		dispatcher.forward(req, resp);
	}
}
