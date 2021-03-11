package com.yaneodo.company.position;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/company/position/editok.do")
public class EditOK extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		String tempsession = "1"; //기업회원 번호
		
		String jseq = "";
		String title = "";
		String enddate = "";
		String image = "";
		String job = "";
		String[] tag = null;
		String place = "";
		String description = "";
		
		
		// 첨부파일 올리기
		try {
	
			// 객체를 생성하는 순간 파일 업로드가 완료
			MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/files"), 1024 * 1024 * 100, "UTF-8",
					new DefaultFileRenamePolicy());
			
			System.out.println(req.getRealPath("/files"));
	
			jseq = multi.getParameter("jseq");
			title = multi.getParameter("title");
			enddate = multi.getParameter("enddate");
			job = multi.getParameter("job");
			tag = multi.getParameterValues("tag");
			place = multi.getParameter("place");
			description = multi.getParameter("description");
			
			image = multi.getFilesystemName("image");
	
			System.out.println("image 파일명 : " + image);
			System.out.println(title);
			System.out.println(job);
			System.out.println(tag[0] + " " + tag[1]);
			System.out.println(place);
			System.out.println(description);
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		JobOpeningDTO dto = new JobOpeningDTO();
		PositionDAO dao = new PositionDAO();
		
		
		// 기업회원 번호로 기업번호를 가져온다
		String companyseq = dao.getCompanySeq(tempsession);
		//System.out.println(companyseq);
		
		dto.setJobopeningseq(jseq);
		dto.setTitle(title);
		dto.setCompanyseq(companyseq);
		dto.setEnddate(enddate);
		dto.setPhoto(image);
		dto.setJob(job);
		dto.setPlace(place);
		dto.setDescription(description);
		
		
		int result = 1;
		
		// 공고 DB에 수정하기
		result = dao.editPosition(dto);
		
		System.out.println("DB 수정 정상적? : " + result);
		
		// 태그 DB에 삭제
		result = dao.deletePositionTag(jseq);
		
		System.out.println("태그 삭제 정상적? : " + result);
		
		// 태그 DB에 재등록
		for (int i=0 ; i<tag.length ; i++) {
			dao.AddPositionTag(jseq, tag[i]);
		}
		
		
		if (result > 0) {
			// 성공
			resp.sendRedirect("/yaneodo/company/position/view.do?jseq=" + jseq);
		} else {
			// 실패 -> 경고 + 뒤로가기
			PrintWriter writer = resp.getWriter();

			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");

			writer.close();

		}


	}

}
