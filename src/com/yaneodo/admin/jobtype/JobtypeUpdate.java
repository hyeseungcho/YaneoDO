package com.yaneodo.admin.jobtype;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/jobtype/jobtypeupdate.do")
public class JobtypeUpdate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		
		//1. 데이터 가져오기
		//2. DB 작업 -> delete -> insert 
		//3. 결과 처리
		
		
		//1.
		//String[] list = req.getParameterValues("jobtype");
		
		String title = req.getParameter("jobtype");
		String jobseq = req.getParameter("jobseq");
		String add = req.getParameter("jobcount");
		
		req.setAttribute("title", title);
		req.setAttribute("jobseq", jobseq);		
		req.setAttribute("add", add);
		
		
//		//req.setAttribute("list", list);
//		
//				
		JobtypeDAO dao = new JobtypeDAO();
//		
//		
		int count = dao.newlist(title, jobseq, add);
		
//		

		resp.sendRedirect("/yaneodo/admin/jobtype/jobtype.do");
			

		
		
		
	}
}
