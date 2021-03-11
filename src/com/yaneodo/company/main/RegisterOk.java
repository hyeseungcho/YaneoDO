package com.yaneodo.company.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/company/main/registerok.do")
public class RegisterOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");

		
		String companyMemberSeq = (String)session.getAttribute("cmseq");

		String name = "";
		String country = "";
		String region = "";
		String address = "";
		String regNum = "";
		String sales = "";
		String industry = "";
		String employeeNum = "";
		String introduction ="";
		String establishment = "";
		String email = "";
		String webAddress = "";
		String photo = "";
		int result = 0;
		
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
									req,
									req.getRealPath("/images/company"),
									1024 * 1024 * 10,
									"UTF-8",
									new DefaultFileRenamePolicy()
									);
			
			//System.out.println(req.getRealPath("/images/company"));

			name = multi.getParameter("name");
			country = multi.getParameter("country");
			region = multi.getParameter("region");
			address = multi.getParameter("address");
			regNum = multi.getParameter("regNum");
			sales = multi.getParameter("sales");
			industry = multi.getParameter("industry");
			employeeNum = multi.getParameter("employeeNum");
			introduction = multi.getParameter("introduction");
			establishment = multi.getParameter("establishment");
			email = multi.getParameter("email");
			webAddress = multi.getParameter("webAddress");
			photo = multi.getFilesystemName("photo");
//			photo = multi.getFilesystemName("photo") != null ? 
//						multi.getFilesystemName("photo") : "nopic.png";
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
			CompanyDAO dao = new CompanyDAO();
			CompanyDTO dto = new CompanyDTO();
					
			dto.setCompanyMemberSeq(companyMemberSeq);
			dto.setName(name);
			dto.setCountry(country);
			dto.setRegion(region);
			dto.setAddress(address);
			dto.setRegNum(regNum);
			dto.setSales(sales);
			dto.setIndustry(industry);
			dto.setEmployeeNum(employeeNum);
			dto.setIntroduction(introduction);
			dto.setEstablishment(establishment);
			dto.setEmail(email);	
			dto.setWebAddress(webAddress);
			dto.setPhoto(photo);
			
			result = dao.add(dto);
			//System.out.println(result);
				
			if (result == 1) {
				
				//기업 등록 후 세션 값 변경(null -> 0)
				session.setAttribute("cmstate", "0");
				
				resp.setCharacterEncoding("UTF-8");				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='utf-8'></head><body>");
				writer.print("<script>");
				writer.print("alert('기업 정보 제출이 완료되었습니다. 관리자 승인 후 이용가능합니다.');");
				writer.print("location.href='/yaneodo/company/main/index.do';"); 
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();

				//resp.sendRedirect("/yaneodo/company/main/index.do");
			

			} else {
				
				resp.setCharacterEncoding("UTF-8");			
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='utf-8'></head><body>");
				writer.print("<script>");
				writer.print("alert('기업 등록에 실패했습니다.');");
				writer.print("location.href='/yaneodo/company/main/register.do';"); 	
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();

		}


//			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/main/index.jsp");
//			dispatcher.forward(req, resp);
	
			
	}
	
}

