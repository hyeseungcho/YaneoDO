package com.yaneodo.member.myyaneodo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;

@WebServlet("/member/myyaneodo/photoupload.do")
public class PhotoUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String seq = "";
		String photo="";

		try {
			MultipartRequest multi = new MultipartRequest(
										req,
										req.getRealPath("/images"),
										1024 * 1024 * 100,
										"UTF-8",
										new DefaultFileRenamePolicy()
									);

			seq = multi.getParameter("seq");
			photo = multi.getFilesystemName("pic") != null?
					multi.getFilesystemName("pic") : "man_01.png";
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO(); 
		dto.setPhoto(photo);
		dto.setCustomerSeq(seq);
	
		int result = dao.photoEdit(dto);
		
		if(result==1) {
			resp.sendRedirect("/yaneodo/member/myyaneodo/myyaneodo.do");
		} else {
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer=resp.getWriter();
			writer.print("<html><head><meta charset='utf-8'></head><body>");
			writer.print("<script>");
			writer.print("alert('수정에 실패하였습니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();

		
	}
	
		

	}
}
