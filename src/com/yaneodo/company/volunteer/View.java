package com.yaneodo.company.volunteer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneodo.member.resume.AbroadDTO;
import com.yaneodo.member.resume.AwardDTO;
import com.yaneodo.member.resume.CertificateDTO;
import com.yaneodo.member.resume.EducationDTO;
import com.yaneodo.member.resume.ExperienceDTO;
import com.yaneodo.member.resume.LanguageDTO;
import com.yaneodo.member.resume.PortfolioDTO;
import com.yaneodo.member.resume.PreferenceDTO;
import com.yaneodo.member.resume.ResumeDAO;
import com.yaneodo.member.resume.TrainingDTO;

@WebServlet("/company/volunteer/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터 가져오기 (pseq + 여러 상태유지 정보)
		// 2. DB 작업
		// 3. jsp 페이지에 돌려주기
		
		
		String tempSession = "1"; // 기업회원번호 임의 세션
		
		//1.
		String search = req.getParameter("search");
		String isread = req.getParameter("isread");
		String job = req.getParameter("job"); 
		String aseq = req.getParameter("aseq"); // 지원공고 seq 정보
		String page = req.getParameter("page"); // 페이지 정보
		
 		
		//2. 
		VolunteerDAO vdao = new VolunteerDAO();
		ResumeDAO rdao = new ResumeDAO();
		
		VolunteerViewDTO vdto = vdao.getView(aseq, tempSession);
		
		String rseq = vdto.getRseq(); // 사용자의 이력서 번호
		System.out.println("rseq : " + rseq);
		
		
		//2.1 이력서 정보를 가진 태그 동적 생성하기.
		String resumeData = ""; // 동적 태그 저장
		
		// 경력
		ArrayList<ExperienceDTO> elist = rdao.getExperienceList(rseq);
		
		if (elist.size() > 0) {
			for (ExperienceDTO dto : elist) {
				resumeData += String.format("<div class=\"row\">\r\n"
					+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
					+ "                                        경력\r\n"
					+ "                                    </div>\r\n"
					+ "                                    <div class=\"col-md-10\">\r\n"
					+ "                                        <div class=\"subtitle\">\r\n"
					+ "                                            <div><span>%s</span></div>\r\n"
					+ "                                            <div style=\"text-align: right;\"><span>%s ~ %s</span></div>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"text\">%s</div>\r\n"
					+ "                                        <div class=\"text\"><span>%s</span>\r\n"
					+ "                                        </div>\r\n"
					+ "                                    </div>\r\n"
					+ "                                </div>",
															dto.getCompany(),
															dto.getStartdate(),
															dto.getEnddate(),
															dto.getField(),
															dto.getJob());
			}
		}
		
		// 학력
		ArrayList<EducationDTO> edlist = rdao.getEducationList(rseq);
		
		if (edlist.size() > 0) {
			for (EducationDTO dto : edlist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        학력\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s | %s</span></div>\r\n"
						+ "                                            <div style=\"text-align: right;\"><span>%s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">%s</div>\r\n"
						+ "                                        <div class=\"text\">입학일 : %s</div>\r\n"
						+ "                                        <div class=\"text\">졸업일 : %s</div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>",dto.getSchoolname(), 
																	dto.getMajor(), 
																	dto.getState(), 
																	dto.getSchooltype(), 
																	dto.getStartdate(), 
																	dto.getEnddate() );
			}
		}
		
		//자격증
		ArrayList<CertificateDTO> clist = rdao.getCertificateList(rseq);
		
		if (clist.size() > 0) {
			for (CertificateDTO dto : clist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        자격증\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s</span></div>\r\n"
						+ "                                            <div style=\"text-align: right;\"><span>취득일 : %s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">등급 : %s</div>\r\n"
						+ "                                        <div class=\"text\">발행기관 : %s</div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>",dto.getType(), dto.getGetdate(), dto.getGrade(), dto.getAgency() );
			}
		}
		
		
		//외국어
		ArrayList<LanguageDTO> llist = rdao.getLanguageList(rseq);
		
		if (llist.size() > 0) {
			for (LanguageDTO dto : llist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        외국어\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">수준 : %s</div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>", dto.getLanguagetype(), dto.getGrade());
			}
		}
		
		// 교육 및 대외활동
		ArrayList<TrainingDTO> tlist = rdao.getTrainingList(rseq);
		
		if (tlist.size() > 0) {
			for (TrainingDTO dto : tlist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        교육 및 대외 활동\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s | %s</span></div>\r\n"
						+ "                                            <div style=\"text-align: right;\"><span>%s ~ %s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">기관 : %s</div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>", dto.getType(), dto.getName(), dto.getStartDate(), dto.getEnddate(), dto.getAgency());
			}
		}
		
		
		// 해외연수
		ArrayList<AbroadDTO> alist = rdao.getAbroadList(rseq);
		
		if (alist.size() > 0) {
			for (AbroadDTO dto : alist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        해외연수\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s | %s</span></div>\r\n"
						+ "                                            <div style=\"text-align: right;\"><span>%s ~ %s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">%s </div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>", dto.getType(), dto.getCountry(), dto.getStartDate(), dto.getEndDate(), dto.getNote());
			}
		}
		
		
		// 수상내역
		ArrayList<AwardDTO> awlist = rdao.getAwardList(rseq);
		
		if (awlist.size() > 0) {
			for (AwardDTO dto : awlist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        수상내역\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s</span></div>\r\n"
						+ "                                            <div style=\"text-align: right;\"><span>취득날짜 : %s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">발행기관 : %s</div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>", dto.getAwardname(), dto.getGetdate(), dto.getAgency());
			}
		}
		
		// 취업 우대사항
		
		ArrayList<PreferenceDTO> prelist = rdao.getPreferenceList(rseq);
		
		if (prelist.size() > 0) {
			for (PreferenceDTO dto : prelist) {
				resumeData += String.format("<div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        취업우대사항\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span>%s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"text\">%s</div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>", dto.getType(), dto.getNote());
			}
		}
		
		
		
		// 포트폴리오
		ArrayList<PortfolioDTO> polist = rdao.getPortfolioList(rseq);
		
		if (polist.size() > 0) {
			for (PortfolioDTO dto : polist) {
				resumeData += String.format(" <div class=\"row\">\r\n"
						+ "                                    <div class=\"col-md-2 subtitle\">\r\n"
						+ "                                        포트폴리오\r\n"
						+ "                                    </div>\r\n"
						+ "                                    <div class=\"col-md-10\">\r\n"
						+ "                                        <div class=\"subtitle\">\r\n"
						+ "                                            <div><span class=\"glyphicon glyphicon-bookmark\"></span><span> %s</span></div>\r\n"
						+ "                                            <div><span class=\"glyphicon glyphicon-file\"></span><span> %s</span></div>\r\n"
						+ "                                        </div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>", dto.getUrl(), dto.getFilename());
			}
		}
		
		
		/*
		if (elist.size() > 0) {
			for (EducationDTO dto : edlist) {
				resumeData += String.format("", );
			}
		}
		*/
		
		
		//3.
		req.setAttribute("vdto", vdto); // 사용자 정보를 반환
		
		req.setAttribute("resumeData", resumeData);
		
		
		


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/volunteer/view.jsp");
		dispatcher.forward(req, resp);
	}

}