package com.yaneodo.member.resume;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/resume/portfolioedit.do")
public class portfolioEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String rseq = "";
		String filename="";
		String orgfilename="";
		String url="";
		String seq="";
		try {
			MultipartRequest multi = new MultipartRequest(
										req,
										req.getRealPath("/files"),
										1024 * 1024 * 100,
										"UTF-8",
										new DefaultFileRenamePolicy()
									);
			
			System.out.println(req.getRealPath("/files"));
			filename = multi.getFilesystemName("attach");
			orgfilename = multi.getOriginalFileName("attach");
			url = multi.getParameter("url");
			seq = multi.getParameter("poseq");
			rseq = multi.getParameter("rseq");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		PortfolioDTO dto = new PortfolioDTO();
		ResumeDAO dao = new ResumeDAO();
		dto.setFilename(filename);
		dto.setPortfolioseq(seq);
		dto.setOrgfilename(orgfilename);
		dto.setUrl(url);
		int result2 = dao.editDate(rseq);
		int result = dao.portfolioEdit(dto);
		
		if(result==1 && result2==2) {
			resp.sendRedirect("/yaneodo/member/resume/resume_write.do?rseq="+rseq);
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
	

