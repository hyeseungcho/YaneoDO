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

@WebServlet("/member/status/match_status.do")
public class Match_status extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HashMap<String,String> map2 = new HashMap<String,String>();
//		String search = req.getParameter("search");
//		if(!(search == null || search.equals(""))) {
//			map2.put("search", search);
//		}
		HashMap<String,String> map = new HashMap<String,String>();

		
		//1. DB작업 > select
		//2. 목록 반환 + JSP전달 & 호출하기
		
		
		HttpSession session = req.getSession();
		String seq = (String)session.getAttribute("seq");

		
		//페이징
		int nowPage = 0;		//현재 페이지번호
		int totalCount = 0;		// 원해요 총 게시물 수 
		int totalCount2 = 0;		// 이력서열람 총 게시물 수 
		int totalCount3 = 0;		//면접제안 총 게시물 수 
		int pageSize = 10;		//한 페이지 당 출력개수
		int totalPage = 0;		//원해요 총 페이지수
		int totalPage2 = 0;		//이력서열람 총 페이지수
		int totalPage3= 0;		//면접제안 총 페이지수
		int begin = 0;			//rnum 시작번호
		int end = 0;			//rnum 끝번호
		int n = 0;				//페이지바 관련변수
		int loop = 0;			//페이지바 관련변수
		int n2 = 0;				//페이지바 관련변수
		int loop2 = 0;			//페이지바 관련변수
		int n3 = 0;				//페이지바 관련변수
		int loop3 = 0;			//페이지바 관련변수
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
		
		ArrayList<MatchDTO> wantlist = dao.wantList(map,seq);
		ArrayList<MatchDTO> readlist = dao.readList(map,seq);
		ArrayList<MatchDTO> matchlist = dao.matchList(map,seq);
		int wantCount = dao.wantedCount(seq);
		int readCount = dao.readCount(seq);
		int matchCount = dao.matchCount(seq);
		//1.5 데이터 조작
				for(MatchDTO dto:wantlist) {
					//날짜에서 시간 잘라내기
					if(dto.getDibDate() == null) {
						dto.setDibDate(dto.getDibDate());
					} else {
						dto.setDibDate(dto.getDibDate().substring(0,11));
					}
				}
				for(MatchDTO dto:readlist) {
					//날짜에서 시간 잘라내기
					if(dto.getReadDate() == null) {
						dto.setReadDate(dto.getReadDate());
					} else {
						dto.setReadDate(dto.getReadDate().substring(0,11));
					}
				}
				for(MatchDTO dto:matchlist) {
					//날짜에서 시간 잘라내기
					if(dto.getMatchDate() == null) {
						dto.setMatchDate(dto.getMatchDate());
					} else {
						dto.setMatchDate(dto.getMatchDate().substring(0,11));
					}
					}

				//페이징 바 만들기
				totalCount = dao.wantedCount(seq); //원해요총게시물 수
				totalCount2 = dao.readCount(seq); //이력서열람총게시물 수
				totalCount3 = dao.matchCount(seq); //면접제안총게시물 수
	
				totalPage= (int)Math.ceil((double)totalCount/pageSize); //원해요 총 페이지 수 
				totalPage2= (int)Math.ceil((double)totalCount2/pageSize); //이력서열람 총 페이지 수 
				totalPage3= (int)Math.ceil((double)totalCount3/pageSize); //면접제안 총 페이지 수 
		
				String pagebar ="";
				String pagebar2 ="";
				String pagebar3 ="";
				loop =1;
				n=((nowPage-1)/blockSize) * blockSize +1;
				loop2 =1;
				n2=((nowPage-1)/blockSize) * blockSize +1;
				loop3 =1;	
				n3=((nowPage-1)/blockSize) * blockSize +1;
				//wantlist
				//이전 10페이지
				if(n==1) {
				pagebar += String.format("<li class='disabled'><a href=\"#!\" aria-label=\"Previous\">"
						+ "             <span aria-hidden=\"true\">&laquo;</span>"
						+ "                            </a>"
						+ "                        </li>");
				}else {
			
						pagebar += String.format("<li><a href=\"/yaneodo/member/status/match_status.do?page=%d\" aria-label=\"Previous\">"
								+ "             <span aria-hidden=\"true\">&laquo;</span>"
								+ "                            </a>"
								+ "                        </li>",n-1);

				}

			      while (!(loop > blockSize || n > totalPage)) {
			         
			         if (nowPage == n) {
			            pagebar += "<li class='active'>";
			         } else {
			            pagebar += "<li>";
			         }
			        	 pagebar += String.format("<a href=\"/yaneodo/member/status/match_status.do?page=%d\">%d</a></li>",n, n);

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
	
						pagebar += String.format("		<li>"
								+ "        <a href=\"/yaneodo/member/status/applied_status.do?page=%d\" aria-label=\"Next\">"
								+ "            <span aria-hidden=\"true\">&raquo;</span>"
								+ "        </a>"
								+ "    </li>",n);
				}
				
				//readlist 
				//이력서열람
				if(n2==1) {
					pagebar2 += String.format("<li class='disabled'><a href=\"#!\" aria-label=\"Previous\">"
							+ "             <span aria-hidden=\"true\">&laquo;</span>"
							+ "                            </a>"
							+ "                        </li>");
					}else {
				
							pagebar2 += String.format("<li><a href=\"/yaneodo/member/status/match_status.do?page=%d\" aria-label=\"Previous\">"
									+ "             <span aria-hidden=\"true\">&laquo;</span>"
									+ "                            </a>"
									+ "                        </li>",n2-1);

					}
			      while (!(loop2 > blockSize || n2 > totalPage2)) {
				         
				         if (nowPage == n2) {
				            pagebar2 += "<li class='active'>";
				         } else {
				            pagebar2 += "<li>";
				         }
				        	 pagebar2 += String.format("<a href=\"/yaneodo/member/status/match_status.do?page=%d\">%d</a></li>",n2, n2);

				         loop2++;
				         n2++;
				      }

					
					//다음 10페이지로 이동
					
					if(n2>totalPage2) {
					pagebar2 += String.format("		<li class='disabled'>"
							+ "        <a href=\"#!\" aria-label=\"Next\">"
							+ "            <span aria-hidden=\"true\">&raquo;</span>"
							+ "        </a>"
							+ "    </li>");
					} else {
		
							pagebar2 += String.format("		<li>"
									+ "        <a href=\"/yaneodo/member/status/applied_status.do?page=%d\" aria-label=\"Next\">"
									+ "            <span aria-hidden=\"true\">&raquo;</span>"
									+ "        </a>"
									+ "    </li>",n2);
					}
					//matchlist
					if(n3==1) {
						pagebar3 += String.format("<li class='disabled'><a href=\"#!\" aria-label=\"Previous\">"
								+ "             <span aria-hidden=\"true\">&laquo;</span>"
								+ "                            </a>"
								+ "                        </li>");
						}else {
					
								pagebar3 += String.format("<li><a href=\"/yaneodo/member/status/match_status.do?page=%d\" aria-label=\"Previous\">"
										+ "             <span aria-hidden=\"true\">&laquo;</span>"
										+ "                            </a>"
										+ "                        </li>",n3-1);

						}
				      while (!(loop3 > blockSize || n3 > totalPage3)) {
					         
					         if (nowPage == n3) {
					            pagebar3 += "<li class='active'>";
					         } else {
					            pagebar3 += "<li>";
					         }
					        	 pagebar3 += String.format("<a href=\"/yaneodo/member/status/match_status.do?page=%d\">%d</a></li>",n3, n3);

					         loop3++;
					         n3++;
					      }

						
						//다음 10페이지로 이동
						
						if(n3>totalPage3) {
						pagebar3 += String.format("		<li class='disabled'>"
								+ "        <a href=\"#!\" aria-label=\"Next\">"
								+ "            <span aria-hidden=\"true\">&raquo;</span>"
								+ "        </a>"
								+ "    </li>");
						} else {
			
								pagebar3 += String.format("		<li>"
										+ "        <a href=\"/yaneodo/member/status/applied_status.do?page=%d\" aria-label=\"Next\">"
										+ "            <span aria-hidden=\"true\">&raquo;</span>"
										+ "        </a>"
										+ "    </li>",n3);
						}
	
		req.setAttribute("wantlist",wantlist);
		req.setAttribute("readlist",readlist);
		req.setAttribute("matchlist",matchlist);
		req.setAttribute("wantcount", wantCount);
		req.setAttribute("readcount", readCount);
		req.setAttribute("matchcount", matchCount);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("pagebar2", pagebar2);
		req.setAttribute("pagebar3", pagebar3);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/status/match_status.jsp");
		dispatcher.forward(req, resp);

	}
}
