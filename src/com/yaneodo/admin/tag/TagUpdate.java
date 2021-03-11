package com.yaneodo.admin.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/tag/tagupdate.do")
public class TagUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		
		//1. 데이터 가져오기
		//2. DB 작업 -> delete -> insert 
		//3. 결과 처리
		
		
		//1.

		
		String ctitle = req.getParameter("ctitle"); // 태그 번호
		String ttitle = req.getParameter("title");
		String add = req.getParameter("ttitlecount");
		
//		req.setAttribute("ctitle", ctitle); //
//		req.setAttribute("ttitle", ttitle);		
//		req.setAttribute("add", add);
		
		System.out.println(ttitle);
		System.out.println(ctitle);
		System.out.println(add);

		
		TagDAO dao = new TagDAO();
		
		int count = dao.getnewtaglist(ttitle, ctitle, add);
		
	

		resp.sendRedirect("/yaneodo/admin/tag/tag.do");
			

		
		
		
	}
}
