package com.yaneodo.admin.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/tag/tagcategoryupdate.do")
public class TagcategoryUpdate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		
		//1. 데이터 가져오기
		//2. DB 작업 -> delete -> insert 
		//3. 결과 처리
		
		
		//1.
		//String[] list = req.getParameterValues("jobtype");
		
		String title = req.getParameter("title");
		String tagseq = req.getParameter("tagtitleseq");
		String add = req.getParameter("tagtitlecount");
		
		req.setAttribute("title", title);
		req.setAttribute("tagseq", tagseq);		
		req.setAttribute("add", add);
		
		
//		//req.setAttribute("list", list);
//		
//				
		TagDAO dao = new TagDAO();
//		
//		
		int count = dao.newlist(title, tagseq, add);
		
//		

		resp.sendRedirect("/yaneodo/admin/tag/tagcategory.do");
			

		
		
		
	}
}
