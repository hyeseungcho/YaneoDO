package com.yaneodo.company.volunteer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/company/volunteer/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 받아오기
		//2. DB 접근해서 받아오기
		//2.1 지원자 사이드메뉴 동적으로 생성하기
		//3. JSP페이지에 넘겨주기
		
		// 테스트용 임의 세션 생성 *************************************
//		HttpSession session = req.getSession();
//		session.setAttribute("cmseq", "1");
		
		String tempSession = "1"; // 기업회원번호 임의 세션
		
		
		
		// 검색어를 저장해놓을 HashMap을 만든다
		HashMap<String,String> map = new HashMap<String,String>();
		
		// 맵에 세션정보도 넣는다
		map.put("session", tempSession);
		
		//1.
		String search = req.getParameter("search");
		String isread = req.getParameter("isread");
		String job = req.getParameter("job");
		
//		System.out.println(isread);
		
		if (!(search == null || search.equals(""))) {
			// 검색중일 때
			// map에 search키값을 가지는 검색어를 넣어놓는다
			map.put("search", search);
			
		}
		
		if (!(isread == null || isread.equals(""))) {
			// 매치업 탭 클릭
			map.put("isread", isread);
		}
		
		if (!(job == null || job.equals(""))) {
			// 동적으로 생성한 탭 클릭했을때
			map.put("job", job);
		}
		
		// 페이징 처리
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 5;		//한페이지당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작 번호
		int end = 0;			//rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		String page = req.getParameter("page");
		
		if (page == null ||  page == "") {
			// 기본 1page
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		// nowPage -> 현재 보려는 페이지 번호
		// 1 page일때 -> where rnum between 1 and 10
		// 2 page일때 -> where rnum between 11 and 20
		// 3 page일때 -> where rnum between 21 and 30
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		// Hashmap에 넣어준다
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		
		// 총 페이지 수 계산하기
		// 총 게시물 수 = 274개
		// 총 페이지수 = 274 / 10 -> 27.4 -> 무조건 올림 28페이지
		
		VolunteerDAO dao = new VolunteerDAO(); 
		
		totalCount = dao.getTotalCount(map); // 총 게시물 수
		System.out.println("게시물 수 : " + totalCount);
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize); // 총 페이지 수
		System.out.println(totalPage);
		
		String pagebar = "";
		
		
		
		loop = 1;
		//n = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		
		
		if(job == null) job = "";
		if(isread == null) isread = "";
		if(search == null) search = "";
		
		
		// 이전 페이지로 이동
		
		if (n == 1) {
			pagebar += String.format("<li class='disabled'>"
					+ "	            <a href=\"#!\" aria-label=\"Previous\">"
					+ "	                <span aria-hidden=\"true\">&laquo;</span>"
					+ "	            </a>"
					+ "	        </li>");
			
		} else {
			pagebar += String.format("<li>"
					+ "	            <a href=\"/yaneodo/company/volunteer/list.do?page=%d&job="+job+"&isread="+isread+"&search="+search+"\" aria-label=\"Previous\">"
					+ "	                <span aria-hidden=\"true\">&laquo;</span>"
					+ "	            </a>"
					+ "	        </li>", n-1);			
		}
		
		
		
		
		// 페이지 번호
		while (!(loop > blockSize || n > totalPage)) {
			
			if (nowPage == n) {
				pagebar += "<li class='active'>";				
			} else {
				pagebar += "<li>";
			}
			pagebar += String.format("<a href=\"/yaneodo/company/volunteer/list.do?page=%d&job="+job+"&isread="+isread+"&search="+search+"\">%d</a></li> ",n, n);
			
			loop++;
			n++;
			
		}
		
		
		// 다음 10페이지로 이동
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'>"
					+ "	            <a href=\"#!\" aria-label=\"Next\">"
					+ "	                <span aria-hidden=\"true\">&raquo;</span>"
					+ "	            </a>"
					+ "	        </li>");
			
		} else {
			pagebar += String.format("<li>"
					+ "	            <a href=\"/yaneodo/company/volunteer/list.do?page=%d\" aria-label=\"Next\">"
					+ "	                <span aria-hidden=\"true\">&raquo;</span>"
					+ "	            </a>"
					+ "	        </li>", n);			
		}
				
				
		
		//2. 
		
		
		ArrayList<VolunteerDTO> list = dao.list(map);
		
		
		
		//2.1 지원자 사이드메뉴 동적으로 생성하기
		String sidemenu = "";
		
		// DB 에서 메뉴 데이터 받아오기.
		ArrayList<String> mlist = dao.mlist(tempSession);
		
		// 태그 만들기
		for (String menuname : mlist) {
			sidemenu += "<li class='side-list-item'"
					+ "onclick=\"location.href='/yaneodo/company/volunteer/list.do?job="+ menuname +"';\"> "+ menuname +"</li>";
		}
		
		
//		<li class='side-list-item side-list-item-selected'
//				onclick="location.href='/yaneodo/company/volunteer/list.do';">전체보기</li>
		
		
		
		
		//3. 
		req.setAttribute("list", list); // Select 해온 목록
		
		req.setAttribute("search", search); // 검색어
		
		req.setAttribute("job", job); // 사이드메뉴의 동적생성 탭인지
		
		req.setAttribute("isread", isread); // 사이드메뉴의 매치업 탭인지
		
		req.setAttribute("sidemenu", sidemenu); // 사이드메뉴 동적코드
		
		req.setAttribute("pagebar", pagebar); // 페이지바 코드 넘겨주기

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/volunteer/list.jsp");
		dispatcher.forward(req, resp);
	}

}