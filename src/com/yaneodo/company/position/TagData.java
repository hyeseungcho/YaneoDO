package com.yaneodo.company.position;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/company/position/tagdata.do")
public class TagData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		// 넘어온 데이터 받기
		String tagcate = req.getParameter("tagcate"); // 태그 카테고리 번호
		
		System.out.println("tagcate : " + tagcate);
		
		
		// DB 작업
		PositionDAO pdao = new PositionDAO();
		
		ArrayList<TagDTO> list = pdao.getCateTagList(tagcate);
		
		
		
		// 데이터 돌려주기
		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		
		temp += "[";
		
			for(TagDTO dto : list) {
				temp += "{";
				temp += String.format("\"tagseq\":\"%s\",", dto.getTagseq());
				temp += String.format("\"tagcategoryseq\":\"%s\",", dto.getTagcategoryseq());
				temp += String.format("\"tagname\":\"%s\"", dto.getTagname());
				temp += "}";
		        temp += ",";
			}
		
		temp = temp.substring(0, temp.length()-1);
	    temp += "]";	
			
		writer.print(temp);
	      
	    writer.close();
		
	}

}