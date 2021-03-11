package com.yaneodo.admin.matchup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneodo.admin.gain.GainDAO;
import com.yaneodo.admin.gain.GainDTO;

@WebServlet("/admin/matchup/matchup_main.do")
public class Matchup_main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1.데이터 가져오기
				//2. DB작업하기 -> select
				//3. 결과처리
				
				req.setCharacterEncoding("UTF-8");
				//1.
				String date = req.getParameter("date");  //가져오기
				
				
				  req.setAttribute("pickdate", date);
				 

				//2. 
				
				Calendar now = Calendar.getInstance();
				Calendar cal = Calendar.getInstance();
				
				if (date == null) {
					date = String.format("%tF", now);
				} else {
					
					try {
						
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						Date dates = formatter.parse(date);
						cal.setTime(dates);
						
						
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				
				
				
				MatchupDAO dao = new MatchupDAO();
				String today = dao.getgaintoday(date); 
				String yest = dao.getgainyest(date); 
				String week = dao.getgainweek(date); 
				
				
				
				req.setAttribute("today", today);
				req.setAttribute("yest", yest);
				req.setAttribute("week", week);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/matchup/matchup_main.jsp");
		dispatcher.forward(req, resp);
	}
}
