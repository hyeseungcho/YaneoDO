package com.yaneodo.member.profile;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneodo.admin.jobtype.JobtypeDAO;
import com.yaneodo.admin.jobtype.JobtypeDTO;
import com.yaneodo.member.MemberDTO;


@WebServlet("/member/profile/edit.do")
public class Edit extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//1. 데이터 가져오기(cseq)
		//2. DB 작업 -> select (프로필정보, 직무리스트)
		//3. 결과 반환 -> JSP 호출하기
		
		
		//1.
		String cseq = req.getParameter("seq"); //회원번호
		
		//2.
		ProfileDAO pdao = new ProfileDAO();
		MemberDTO pdto = pdao.getProfile(cseq); //프로필정보 받아오기
		
		JobtypeDAO jdao = new JobtypeDAO();
		ArrayList<JobtypeDTO> jlist = jdao.getlist(); //직무리스트 받아오기
		
		SkillDAO sdao = new SkillDAO();
		ArrayList<SkillDTO> slist = sdao.getlist(); //스킬리스트 받아오기
		
		pdao.close();
		jdao.close();
		sdao.close();
		
		//3.
		req.setAttribute("pdto", pdto);
		req.setAttribute("jlist", jlist);
		req.setAttribute("slist", slist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/profile/edit.jsp");
		dispatcher.forward(req, resp);
	}

}
