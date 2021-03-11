package com.yaneodo.member.myyaneodo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;

@WebServlet("/member/myyaneodo/customer_editdata.do")
public class Customer_editData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//중복검사데이터가져오기

		String nickName = req.getParameter("nickName");

		
		//가져온데이터담기
		MemberDAO dao = new MemberDAO();

		
		
		//중복검사
		int checkNick = dao.checkNick(nickName);
		
		//결과처리
		PrintWriter writer=resp.getWriter();
		
		writer.print(checkNick);
		
		writer.close();
		
	
		
	}
}

