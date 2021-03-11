package com.yaneodo.member.profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;

@WebServlet("/member/profile/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 데이터 가져오기(seq, school, major, company)
		//2. DB 작업 -> update
		//3. 결과 반환 -> 알림
		
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String customerSeq = req.getParameter("customerSeq"); //수정할 회원번호
		String school = req.getParameter("school");
		String major = req.getParameter("major");
		String company = req.getParameter("company");
		String introduction = req.getParameter("introduction");
		
		
		//2.
		ProfileDAO dao = new ProfileDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setSchool(school);
		dto.setMajor(major);
		dto.setCompany(company);
		dto.setCustomerSeq(customerSeq);
		dto.setIntroduction(introduction);
		
		
		int result = dao.editProfile(dto); //프로필수정하기
		System.out.println(result);
		
		if(result > 0) {

			//프로필수정 성공 -> 프로필보기로 이동(view.do)
			resp.sendRedirect("/yaneodo/member/profile/view.do?seq=" + customerSeq);
			
		} else {
			//프로필수정 실패 -> 경고 + 뒤로 가기
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
