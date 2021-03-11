package com.yaneodo.admin.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/company/companyapprovelist.do")
public class CompanyApproveList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		HashMap<String, String> map = new HashMap<String, String>();
		
		//페이징
		int nowPage = 0; 		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한페이지 당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage -1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		//1. DB작업 > select
		CompanyDAO dao = new CompanyDAO();
		
		ArrayList<CompanyDTO> list = dao.list(map);
		
		totalCount = dao.getTotalCount(map);
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		String pagebar = "";
		
		loop = 1;
		
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		if (n == 1) {
			pagebar += String.format("<li class='disabled'>"
					+ "            <a href=\"#!\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>");
		} else {
			pagebar += String.format("<li>"
					+ "            <a href=\"/yaneodo/admin/company/companyapprovelist.do?page=%d\" aria-label=\"Previous\">"
					+ "                <span aria-hidden=\"true\">&laquo;</span>"
					+ "            </a>"
					+ "        </li>", n - 1);
		}
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='active'>";				
			} else {
				pagebar += "<li>";
			}
			
			pagebar += String.format("<a href=\"/yaneodo/admin/company/companyapprovelist.do?page=%d\">%d</a><li>", n, n);
			
			loop++;
			n++;
			
		}
		
		if (n > totalPage) {
		pagebar += String.format("<li class='disabled'>"
				+ "            <a href=\"#!\" aria-label=\"Next\">"
				+ "                <span aria-hidden=\"true\">&raquo;</span>"
				+ "            </a>"
				+ "        </li>");
		} else {
		pagebar += String.format("<li>"
				+ "            <a href=\"/yaneodo/admin/company/companyapprovelist.do?page=%d\" aria-label=\"Next\">"
				+ "                <span aria-hidden=\"true\">&raquo;</span>"
				+ "            </a>"
				+ "        </li>", n);
		}
		
		
		
		//2.
		req.setAttribute("list", list);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/company/companyapprovelist.jsp");
		dispatcher.forward(req, resp);

	}

}
