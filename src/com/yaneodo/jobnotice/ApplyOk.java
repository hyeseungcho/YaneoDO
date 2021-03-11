package com.yaneodo.jobnotice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDTO;
import com.yaneodo.member.profile.ProfileDAO;

@WebServlet("/jobnotice/applyok.do")
public class ApplyOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(jseq, cseq, rseq)
		//2. DB 작업 -> update, insert (기본이력서 변경, 지원 테이블에 추가)
		//3. 결과 반환 -> 알림
		
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String cseq = (String)session.getAttribute("cseq"); //회원번호
		String jseq = req.getParameter("jobOpeningSeq"); //공고번호
		String rseq = req.getParameter("resume"); //선택한 이력서번호
		
		
		//2.1 이력서선택 : 기본이력서로 변경됨
		MemberDTO dto = new MemberDTO();
		ProfileDAO dao = new ProfileDAO();
		
		dto.setCustomerSeq(cseq);
		dto.setResumeSeq(rseq);
		
		int result1 = dao.editBasicResume(dto); //기본이력서 변경

		dao.close();
		

		//2.2 지원테이블 추가
		ApplyDTO adto = new ApplyDTO();
		ApplyDAO adao = new ApplyDAO();
		
		adto.setCustomerSeq(cseq);
		adto.setJobOpeningSeq(jseq);
		
		int result2 = adao.add(adto); //지원테이블에 추가
		
		adao.close();
		
		int result = result1 * result2;
		
		
		
		if(result > 0) {

			//이력서등록, 지원 성공 -> 지원현황 보기로 이동
			
			//지원현황 보기 페이지로 수정해야함
			resp.sendRedirect("/yaneodo/member/profile/view.do?seq=" + cseq);

			
//			resp.setCharacterEncoding("UTF-8");
//			
//			PrintWriter writer = resp.getWriter();
////			writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//			writer.print("<html>");
//			writer.print("<body>");
//			writer.print("<script>");
//			writer.print("alert('My지원현황에서 지원을 완료하세요');");
//			writer.print("history.back();");
//			writer.print("</script>");
//			writer.print("</body></html>");			
//			writer.close();
//			
			
		} else {
			//실패 -> 경고 + 뒤로 가기
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
		}
		
		//jsp 만들필요없음 위에 페이지만듦
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/profile/editok.jsp");
//		dispatcher.forward(req, resp);

	}

}
