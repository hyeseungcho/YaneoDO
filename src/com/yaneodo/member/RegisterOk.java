package com.yaneodo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/registerok.do")
public class RegisterOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		//2. 파일 업로드 처리(pic)
		//3. DB 작업 > insert
		//4. 결과 반환 > 처리
		
		req.setCharacterEncoding("UTF-8");
		
		String email = "";
		String name = "";
		String nickName = "";
		String password = "";
		String phone = "";
		String birth = "";
		String gender = "";
		String photo = "";
		
		int result = 0;
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
									req, 
									req.getRealPath("/images/member"),
									1024 * 1024 * 10,
									"UTF-8",
									new DefaultFileRenamePolicy()
									);
			
			email = multi.getParameter("email");
			name = multi.getParameter("name");
			nickName = multi.getParameter("nickName");
			password = multi.getParameter("password");
			phone = multi.getParameter("phone");
			birth = multi.getParameter("birth");
			gender = multi.getParameter("gender");
			photo = multi.getFilesystemName("photo");

			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			
			dto.setEmail(email);
			dto.setName(name);
			dto.setNickName(nickName);
			dto.setPassword(password);
			dto.setPhone(phone);
			dto.setBirth(birth);
			dto.setGender(gender);
			dto.setPhoto(photo);
			
			result = dao.add(dto);
			
			if (result == 1) {
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('회원가입이 완료되었습니다.');");
				/* writer.print("location.href='/codestudy/board/list.do;'"); */
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
				
				resp.sendRedirect("/index.do");
				
			} else {
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('회원가입에 실패했습니다. 고객센터로 문의바랍니다.');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
				
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}

		/*
		 * RequestDispatcher dispatcher =
		 * req.getRequestDispatcher("/WEB-INF/views/member/registerok.jsp");
		 * dispatcher.forward(req, resp);
		 */

	}
}