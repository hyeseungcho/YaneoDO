package com.yaneodo.admin.gain;

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

import com.yaneodo.admin.matchup.MatchupDAO;
import com.yaneodo.admin.matchup.MatchupDTO;

@WebServlet("/admin/gain/gain.do")
public class Gain extends HttpServlet {

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
		
		GainDAO dao = new GainDAO();
		GainDTO dtoday = dao.getgainday(date); 
		GainDTO dtoweek = dao.getgainweek(date); 
		GainDTO dtomonth = dao.getgainmonth(date); 
		
		
		
		req.setAttribute("dto", dtoday);
		req.setAttribute("dtoweek", dtoweek);
		req.setAttribute("dtomonth", dtomonth);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/gain/gain.jsp");
		dispatcher.forward(req, resp);
	}
}
