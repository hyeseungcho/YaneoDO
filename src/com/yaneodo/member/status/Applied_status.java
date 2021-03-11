package com.yaneodo.member.status;

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




@WebServlet("/member/status/applied_status.do")
public class Applied_status extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HashMap<String,String> map2 = new HashMap<String,String>();
		String search = req.getParameter("search");
		if(!(search == null || search.equals(""))) {
			map2.put("search", search);
		}
		HashMap<String,String> map = new HashMap<String,String>();
		String status = req.getParameter("status");
		if(!(status == null || status.equals(""))) {
			map.put("status", status);
		}
		
		//1. DB작업 > select
		//2. 목록 반환 + JSP전달 & 호출하기
		
		
		HttpSession session = req.getSession();
		String seq = (String)session.getAttribute("seq");

		
		//페이징
		int nowPage = 0;		//현재 페이지번호
		int totalCount = 0;		//전체현황 총 게시물 수 
		int pageSize = 10;		//한 페이지 당 출력개수
		int totalPage = 0;		//전체 현황 총 페이지수
		int begin = 0;			//rnum 시작번호
		int end = 0;			//rnum 끝번호
		int n = 0;				//전체 현황 페이지바 관련변수
		int loop = 0;			//전체 현황 페이지바 관련변수
		int n2 = 0;				//지원중 페이지바 관련변수
		int loop2 = 0;			//지원중 페이지바 관련변수
		int blockSize = 10;		//페이지바 관련변수
		
		
		//list.do
		//list.do -> list.do?page=1
		//list.do -> list.do?page=2
		
		String page = req.getParameter("page");
		
		if(page == null || page =="") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		//nowPage -> 현재 보려는 페이지 번호
		//1page = where rnum between 1 and 10
		//2page = where rnum between 11 and 20
		//3page = where rnum between 21 and 30
		
		
		begin =((nowPage-1)*pageSize) +1;
		end = begin + pageSize-1;
		
		map.put("begin", begin +"");
		map.put("end", end+"");
		
		


		StatusDAO dao = new StatusDAO();
		
		ArrayList<StatusDTO> list = dao.list(map,seq);
		int cntAll = dao.cntAll(seq);
		int cntWriting = dao.cntWriting(seq);
		int cntComplete = dao.cntComplete(seq);
		int cntResumePass = dao.cntResumePass(seq);
		int cntPass = dao.cntPass(seq);
		int cntFail = dao.cntFail(seq);
		
		//1.5 데이터 조작
//				for(StatusDTO dto:list) {
//					//날짜에서 시간 잘라내기
//					dto.setApplyDate(dto.getApplyDate().substring(0,10));
//					}
		
				
				//페이징 바 만들기
				totalCount = dao.getTotalCount(map,seq); //총게시물 수
				System.out.println(totalCount);
				
				totalPage= (int)Math.ceil((double)totalCount/pageSize); //총 페이지 수 

				
				String pagebar ="";
				
//				for(int i=1; i<=totalPage; i++) {
//					
//					if(nowPage==i) {
//						pagebar +="<li class='active'>";
//					} else {
//						pagebar +="<li>";
//					}
//					
//					pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\">%d</a></li>",i,i);
//				}
			
				
				loop =1;

				//n=1;
				
				n=((nowPage-1)/blockSize) * blockSize +1;
	
				
				//이전 10페이지
				if(n==1) {
				pagebar += String.format("<li class='disabled'><a href=\"#!\" aria-label=\"Previous\">"
						+ "             <span aria-hidden=\"true\">&laquo;</span>"
						+ "                            </a>"
						+ "                        </li>");
				}else {
					if(status == null || status == "") {
						pagebar += String.format("<li><a href=\"/yaneodo/member/status/applied_status.do?page=%d\" aria-label=\"Previous\">"
								+ "             <span aria-hidden=\"true\">&laquo;</span>"
								+ "                            </a>"
								+ "                        </li>",n-1);
					} else {
						pagebar += String.format("<li><a href=\"/yaneodo/member/status/applied_status.do?status=%s&page=%d\" aria-label=\"Previous\">"
						+ "             <span aria-hidden=\"true\">&laquo;</span>"
						+ "                            </a>"
						+ "                        </li>",status,n-1);
					}
				}
				
			      
			      while (!(loop > blockSize || n > totalPage)) {
			         
			         if (nowPage == n) {
			            pagebar += "<li class='active'>";
			         } else {
			            pagebar += "<li>";
			         }
			         if(status == null || status == "") {
			        	 pagebar += String.format("<a href=\"/yaneodo/member/status/applied_status.do?page=%d\">%d</a></li>",n, n);
			        
			         } else {
			        	 pagebar += String.format("<a href=\"/yaneodo/member/status/applied_status.do?status=%s&page=%d\">%d</a></li>",status,n, n);
			        	 
			         }
			    	 loop++;
		        	 n++;
	
	
			      }

				
				//다음 10페이지로 이동
				
				if(n>totalPage) {
				pagebar += String.format("		<li class='disabled'>"
						+ "        <a href=\"#!\" aria-label=\"Next\">"
						+ "            <span aria-hidden=\"true\">&raquo;</span>"
						+ "        </a>"
						+ "    </li>");
				} else {
					if(status == null || status == "") {
						pagebar += String.format("		<li>"
								+ "        <a href=\"/yaneodo/member/status/applied_status.do?page=%d\" aria-label=\"Next\">"
								+ "            <span aria-hidden=\"true\">&raquo;</span>"
								+ "        </a>"
								+ "    </li>",n);
					} else {
						pagebar += String.format("		<li>"
								+ "        <a href=\"/yaneodo/member/status/applied_status.do?status=%s&page=%d\" aria-label=\"Next\">"
								+ "            <span aria-hidden=\"true\">&raquo;</span>"
								+ "        </a>"
								+ "    </li>",status,n);
					}
				}
	
		req.setAttribute("list",list);
		req.setAttribute("status", status);
		req.setAttribute("cntAll", cntAll);
		req.setAttribute("cntWriting", cntWriting);
		req.setAttribute("cntComplete", cntComplete);
		req.setAttribute("cntResumePass", cntResumePass);
		req.setAttribute("cntPass", cntPass);
		req.setAttribute("cntFail", cntFail);
		req.setAttribute("pagebar", pagebar);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/status/applied_status.jsp");
		dispatcher.forward(req, resp);

	}
}
