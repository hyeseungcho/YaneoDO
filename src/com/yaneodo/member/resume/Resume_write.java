package com.yaneodo.member.resume;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;



@WebServlet("/member/resume/resume_write.do")
public class Resume_write extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		

		String rseq = req.getParameter("rseq");
		
		
		ResumeDAO dao = new ResumeDAO();
		ResumeDTO dto = dao.getResume(rseq);
		
		ArrayList<AbroadDTO> ablist = dao.getAbroadList(rseq);
		ArrayList<AwardDTO> awlist = dao.getAwardList(rseq);
		ArrayList<CertificateDTO> celist = dao.getCertificateList(rseq);
		ArrayList<EducationDTO> edlist = dao.getEducationList(rseq);
		ArrayList<ExperienceDTO> exlist = dao.getExperienceList(rseq);
		ArrayList<LanguageDTO> lalist = dao.getLanguageList(rseq);
		ArrayList<PortfolioDTO> polist = dao.getPortfolioList(rseq);
		ArrayList<PreferenceDTO> prlist = dao.getPreferenceList(rseq);
		ArrayList<TrainingDTO> trlist = dao.getTrainingList(rseq);

		req.setCharacterEncoding("UTF-8");

		req.setAttribute("dto", dto);
		req.setAttribute("ablist", ablist);
		req.setAttribute("awlist", awlist);
		req.setAttribute("celist", celist);
		req.setAttribute("edlist", edlist);
		req.setAttribute("exlist", exlist);
		req.setAttribute("lalist", lalist);
		req.setAttribute("polist", polist);
		req.setAttribute("prlist", prlist);
		req.setAttribute("trlist", trlist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/resume/resume_write.jsp");
		dispatcher.forward(req, resp);
		
		}
		


	
}
