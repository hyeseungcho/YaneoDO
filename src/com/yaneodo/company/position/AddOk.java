package com.yaneodo.company.position;

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

@WebServlet("/company/position/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		String tempsession = "1"; //기업회원 번호
		
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
		
		
		dto.setTitle(title);
		dto.setCompanyseq(companyseq);
		dto.setEnddate(enddate);
		dto.setPhoto(image);
		dto.setJob(job);
		dto.setPlace(place);
		dto.setDescription(description);
		
		
		int result = 1;
		
		// 공고 DB에 등록
		result = dao.AddPosition(dto);
		
		
		// 등록한 공고의 공고번호를 가져와야 함.
		String jobOpeningSeq = dao.getJobOpeningSeq(dto);
		//System.out.println("공고번호 : " + jobOpeningSeq);
		
		// 태그 DB에 등록
		for (int i=0 ; i<tag.length ; i++) {
			System.out.println(tag[i]);
			dao.AddPositionTag(jobOpeningSeq, tag[i]);
		}
		
		
		if (result == 1) {
			// 성공
			resp.sendRedirect("/yaneodo/company/position/list.do");
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