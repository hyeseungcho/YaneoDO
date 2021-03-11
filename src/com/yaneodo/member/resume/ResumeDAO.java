package com.yaneodo.member.resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yaneodo.DBUtil;
import com.yaneodo.jobnotice.JobNoticeDTO;
import com.yaneodo.member.MemberDTO;


public class ResumeDAO {
	
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ResumeDAO() {
		//DB 연결
		conn = DBUtil.open();
	}
	
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	/***
	 * 회원번호 해당하는 이력서 목록조회
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public ArrayList<ResumeDTO> list(String seq) {
	
		try {
			
			String sql = "select* from tblresume where customerseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();

			//ResultSet -> ArrayList<DTO>
			ArrayList<ResumeDTO> list = new ArrayList<ResumeDTO>();

			while (rs.next()) {
				
				ResumeDTO dto = new ResumeDTO();
				
				dto.setResumeSeq(rs.getString("resumeSeq"));
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setEditDate(rs.getString("editDate"));
				dto.setOrgfileName(rs.getString("orgfileName"));
				dto.setFileName(rs.getString("fileName"));
				dto.setIntroduce(rs.getString("introduce"));
				
				
				list.add(dto);
			
			} 
			
			return list;
			
		
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}



	/**
	 * Company/volunteer/view 서블릿에서 이력서 경력정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<ExperienceDTO> getExperienceList(String rseq) {
		
		try {
			
			String sql = "select * from tblExperience where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<ExperienceDTO> list = new ArrayList<ExperienceDTO>();
			
			while (rs.next()) {

				ExperienceDTO dto = new ExperienceDTO();
				
				dto.setExperienceseq(rs.getString("experienceseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setCompany(rs.getString("company"));
				dto.setField(rs.getString("field"));
				dto.setJob(rs.getString("job"));
				if(rs.getString("startdate")==null || rs.getString("startdate") =="") {
					dto.setStartdate(rs.getString("startdate"));
					
				} else {
					dto.setStartdate(rs.getString("startdate").substring(0,11));	
				}
				
				if(rs.getString("enddate") ==null || rs.getString("enddate") =="") {
					dto.setEnddate(rs.getString("enddate"));
				} else {
					dto.setEnddate(rs.getString("enddate").substring(0,11));	
				}
				
			
				list.add(dto);
			
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서 학력정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<EducationDTO> getEducationList(String rseq) {
		
		try {
			
			String sql = "select * from tblEducation where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<EducationDTO> list = new ArrayList<EducationDTO>();
			
			while (rs.next()) {

				EducationDTO dto = new EducationDTO();
				
				dto.setEducationseq(rs.getString("educationseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setSchooltype(rs.getString("schooltype"));
				dto.setSchoolname(rs.getString("schoolname"));
				dto.setMajor(rs.getString("major"));
				if(rs.getString("startdate")==null || rs.getString("startdate") =="") {
					dto.setStartdate(rs.getString("startdate"));
					
				} else {
					dto.setStartdate(rs.getString("startdate").substring(0,11));	
				}
				
				if(rs.getString("enddate") ==null || rs.getString("enddate") =="") {
					dto.setEnddate(rs.getString("enddate"));
				} else {
					dto.setEnddate(rs.getString("enddate").substring(0,11));	
				}
				dto.setState(rs.getString("state"));
				
			
				list.add(dto);
			
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서 자격증 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<CertificateDTO> getCertificateList(String rseq) {
		try {
			
			String sql = "select * from tblCertificate where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<CertificateDTO> list = new ArrayList<CertificateDTO>();
			
			while (rs.next()) {

				CertificateDTO dto = new CertificateDTO();
				
				dto.setCertificateseq(rs.getString("certificateseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setType(rs.getString("type"));
				dto.setGrade(rs.getString("grade"));
				if(rs.getString("getdate")==null || rs.getString("getdate") =="") {
					dto.setGetdate(rs.getString("getdate"));
					
				} else {
					dto.setGetdate(rs.getString("getdate").substring(0,11));	
				}
				dto.setAgency(rs.getString("agency"));

				list.add(dto);
			
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}


	/**
	 * Company/volunteer/view 서블릿에서 이력서의 외국어 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<LanguageDTO> getLanguageList(String rseq) {
		try {
			
			String sql = "select * from tblLanguage where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<LanguageDTO> list = new ArrayList<LanguageDTO>();
			
			while (rs.next()) {

				LanguageDTO dto = new LanguageDTO();
				
				dto.setLanguageseq(rs.getString("languageseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setLanguagetype(rs.getString("languagetype"));
				dto.setGrade(rs.getString("grade"));


				list.add(dto);	
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서의 교육 및 대외활동 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<TrainingDTO> getTrainingList(String rseq) {
		try {
			
			String sql = "select * from tblTraining where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<TrainingDTO> list = new ArrayList<TrainingDTO>();
			
			while (rs.next()) {

				TrainingDTO dto = new TrainingDTO();
				
				dto.setTrainingseq(rs.getString("trainingseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setType(rs.getString("type"));
				dto.setName(rs.getString("name"));

				if(rs.getString("startdate")==null || rs.getString("startdate") =="") {
					dto.setStartDate(rs.getString("startdate"));
					
				} else {
					dto.setStartDate(rs.getString("startdate").substring(0,11));	
				}
				
				if(rs.getString("enddate") ==null || rs.getString("enddate") =="") {
					dto.setEnddate(rs.getString("enddate"));
				} else {
					dto.setEnddate(rs.getString("enddate").substring(0,11));	
				}
				dto.setAgency(rs.getString("agency"));
				

				list.add(dto);	
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서의 해외연수 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<AbroadDTO> getAbroadList(String rseq) {
		try {
			
			String sql = "select * from tblAbroad where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<AbroadDTO> list = new ArrayList<AbroadDTO>();
			
			while (rs.next()) {

				AbroadDTO dto = new AbroadDTO();
				
				dto.setAbroadseq(rs.getString("abroadseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setCountry(rs.getString("country"));
				dto.setType(rs.getString("type"));
				if(rs.getString("startdate")==null || rs.getString("startdate") =="") {
					dto.setStartDate(rs.getString("startdate"));
					
				} else {
					dto.setStartDate(rs.getString("startdate").substring(0,11));	
				}
				
				if(rs.getString("enddate") ==null || rs.getString("enddate") =="") {
					dto.setEndDate(rs.getString("enddate"));
				} else {
					dto.setEndDate(rs.getString("enddate").substring(0,11));	
				}
				dto.setNote(rs.getString("note"));
	
				list.add(dto);	
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서의 수상내역 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<AwardDTO> getAwardList(String rseq) {
		try {
			
			String sql = "select * from tblAward where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<AwardDTO> list = new ArrayList<AwardDTO>();
			
			while (rs.next()) {

				AwardDTO dto = new AwardDTO();
				
				dto.setAwardseq(rs.getString("awardseq"));
				dto.setResumeSeq(rs.getString("resumeseq"));
				dto.setAwardname(rs.getString("awardname"));
				if(rs.getString("getdate")==null || rs.getString("getdate") =="") {
					dto.setGetdate(rs.getString("getdate"));
					
				} else {
					dto.setGetdate(rs.getString("getdate").substring(0,11));	
				}
				
				dto.setAgency(rs.getString("agency"));
	
				list.add(dto);	
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서의 취업 우대사항 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<PreferenceDTO> getPreferenceList(String rseq) {
		try {
			
			String sql = "select * from tblPreference where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<PreferenceDTO> list = new ArrayList<PreferenceDTO>();
			
			while (rs.next()) {

				PreferenceDTO dto = new PreferenceDTO();
				
				dto.setPreferenceseq(rs.getString("preferenceseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setType(rs.getString("type"));
				dto.setNote(rs.getString("note"));
	
				list.add(dto);	
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * Company/volunteer/view 서블릿에서 이력서의 포트폴리오 정보를 리턴받는다
	 * @param resq 이력서 번호
	 * @return
	 */
	public ArrayList<PortfolioDTO> getPortfolioList(String rseq) {
		try {
			
			String sql = "select * from tblPortfolio where resumeseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			rs = pstat.executeQuery();
			
			ArrayList<PortfolioDTO> list = new ArrayList<PortfolioDTO>();
			
			while (rs.next()) {

				PortfolioDTO dto = new PortfolioDTO();
				
				dto.setPortfolioseq(rs.getString("portfolioseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setFilename(rs.getString("filename"));
				dto.setOrgfilename(rs.getString("orgfilename"));
				dto.setUrl(rs.getString("url"));
	
				list.add(dto);	
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}



	/***
	 * 이력서 작성하기선택시, 이력서생성
	 * @author 혜승
	 * @param dto 
	 * @param seq
	 * @param rseq 
	 */
	
	public int resumeWrite(MemberDTO dto, String seq, String num) {

		try {
			
			
			String sql ="insert into tblresume (resumeseq, customerseq,orgfilename,filename,introduce,name,phone,email,writedate,editdate) values (resumeseq.nextval,?,?,?,'',?,?,?,default,default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, dto.getName() + num);
			pstat.setString(3, dto.getName() + num );
			pstat.setString(4, dto.getName());
			pstat.setString(5, dto.getPhone());
			pstat.setString(6, dto.getEmail());
			
			int result = pstat.executeUpdate();
			
		
			return result;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
		
	}

	/***
	 * 최신에 생성된 이력서 번호가져오기
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public String newResume(String seq) {
		try {
			String sql ="select max(resumeseq) as rseq from tblresume where customerseq = (select customerseq from tblcustomer where customerseq = "+seq+")";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getString("rseq");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/***
	 * 선택한 이력서 정보 가져오기
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public ResumeDTO getResume(String rseq) {
	
		try {
			
			String sql ="select * from tblResume where resumeseq = "+rseq ;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				ResumeDTO dto = new ResumeDTO();
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setOrgfileName(rs.getString("orgfilename"));
				dto.setFileName(rs.getString("filename"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setResumeSeq(rs.getString("resumeSeq"));
				
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}

	/***
	 * 특정 회원 이력서개수 가져오기. 
	 * @혜승
	 * @param seq
	 * @return
	 */
	public String num(String seq) {
		try {
			String sql = "select count(*) as cnt from tblresume where customerseq = " +seq;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getString("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/***
	 * 경력 추가 
	 * @author 혜승
	 * @param rseq
	 * @return
	 */

	public int experienceAdd(String rseq) {
		try {
			
			String sql = "insert into tblexperience (experienceseq, resumeseq, company, field, job, startdate, enddate) values (experienceseq.nextVal, ?,'','','','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 경력 삭제
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int experienceDelete(String seq) {

		try {
			
			String sql = "delete from tblexperience where experienceseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


	
	/***
	 * 학력 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int educationAdd(String rseq) {
		try {
			
			String sql = "insert into tbleducation (educationseq, resumeseq, schooltype, schoolname, major, startdate, enddate, state) values (educationseq.nextVal, ?,'','','','','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 학력 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int educationDelete(String seq) {
		try {
			
			String sql = "delete from tbleducation where educationseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	/***
	 * 자격증 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int certificateAdd(String rseq) {
		try {
			
			String sql = "insert into tblcertificate (certificateseq, resumeseq, type, grade, getdate, agency) values (certificateseq.nextVal, ?,'','','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 자격증 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int certificateDelete(String seq) {
		try {
			
			String sql = "delete from tblcertificate where certificateseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 수상 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int awardAdd(String rseq) {
		try {
			
			String sql = "insert into tblaward (awardseq, resumeseq, awardname, getdate, agency) values (awardseq.nextVal, ?,'','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 수상 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int awardDelete(String seq) {
		try {
			
			String sql = "delete from tblaward where awardseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 대외활동 및 교육 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int trainingAdd(String rseq) {
		try {
			
			String sql = "insert into tbltraining (trainingseq, resumeseq, type, name, startdate, enddate,agency) values (trainingseq.nextVal, ?,'','','','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 대외활동 및 교육 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int trainingDelete(String seq) {
		try {
			
			String sql = "delete from tbltraining where trainingseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/***
	 * 해외 연수 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int abroadAdd(String rseq) {
		try {
			
			String sql = "insert into tblabroad (abroadseq, resumeseq, type, country, startdate, enddate, note) values (abroadseq.nextVal, ?,'','','','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 해외연수 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int abroadDelete(String seq) {
		try {
			
			String sql = "delete from tblabroad where abroadseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/***
	 * 외국어 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int languageAdd(String rseq) {
		try {
			
			String sql = "insert into tbllanguage (languageseq, resumeseq, languagetype, grade) values (languageseq.nextVal, ?,'','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 외국어 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int languageDelete(String seq) {
		try {
			
			String sql = "delete from tbllanguage where languageseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 취업우대사항 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int preferenceAdd(String rseq) {
		try {
			
			String sql = "insert into tblpreference (preferenceseq, resumeseq, type, note) values (preferenceseq.nextVal, ?,'','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 취업우대사항 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int preferenceDelete(String seq) {
		try {
			
			String sql = "delete from tblpreference where preferenceseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 포트폴리오 추가
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int portfolioAdd(String rseq) {
		try {
			
			String sql = "insert into tblportfolio (portfolioseq, resumeseq, url, filename, orgfilename) values (portfolioseq.nextVal, ?,'','','')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 포트폴리오 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int portfolioDelete(String seq) {
		try {
			
			String sql = "delete from tblportfolio where portfolioseq =" + seq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 이력서 타이틀, 소개 수정
	 * @author 혜승
	 * @param dto
	 */
	public int resumeEdit(ResumeDTO dto) {
		try {
			
			String sql ="update tblResume set orgfilename = ?, filename =?, introduce=?, name=?, phone=?, email=?, editDate = default where resumeseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getOrgfileName());
			pstat.setString(2, dto.getFileName());
			pstat.setString(3, dto.getIntroduce());
			pstat.setString(4, dto.getName());
			pstat.setString(5, dto.getPhone());
			pstat.setString(6, dto.getEmail());
			pstat.setString(7, dto.getResumeSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 교육 및 대외활동 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int trainingEdit(TrainingDTO dto) {
		try {
			
			String sql ="update tbltraining set type=?, name=?, startdate=?, enddate=?, agency=? where trainingseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getType());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getStartDate());
			pstat.setString(4, dto.getEnddate());
			pstat.setString(5, dto.getAgency());
			pstat.setString(6, dto.getTrainingseq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 경력 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int experienceEdit(ExperienceDTO dto) {
	try {
			
			String sql ="update tblexperience set company=?, field=?, job=? ,startdate=?, enddate=?  where experienceseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getCompany());
			pstat.setString(2, dto.getField());
			pstat.setString(3, dto.getJob());
			pstat.setString(4, dto.getStartdate());
			pstat.setString(5, dto.getEnddate());
			pstat.setString(6, dto.getExperienceseq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	
	/***
	 * 학력 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int educationEdit(EducationDTO dto) {
	try {
			
			String sql ="update tbleducation set schooltype=?, schoolName=?, major=? ,startdate=?, enddate=?, state=?  where educationseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSchooltype());
			pstat.setString(2, dto.getSchoolname());
			pstat.setString(3, dto.getMajor());
			pstat.setString(4, dto.getStartdate());
			pstat.setString(5, dto.getEnddate());
			pstat.setString(6, dto.getState());
			pstat.setString(7, dto.getEducationseq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}


	public int languageEdit(LanguageDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}


	/***
	 * 수정시간 업데이트
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int editDate(String rseq) {
		
		try {
			String sql = "update tblresume set editdate = default where resumeseq = ?";
			pstat.setString(1, rseq);
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 취업우대사항 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int preferenceEdit(PreferenceDTO dto) {
	try {
			
			String sql ="update tblpreference set type=?, note=? where preferenceseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getType());
			pstat.setString(2, dto.getNote());
			pstat.setString(3, dto.getPreferenceseq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 자격증 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int certificateEdit(CertificateDTO dto) {
		try {
			
			String sql ="update tblcertificate set type=?, grade=?, getDate=?, agency=? where certificateseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getType());
			pstat.setString(2, dto.getGrade());
			pstat.setString(3, dto.getGetdate());
			pstat.setString(4, dto.getAgency());
			pstat.setString(5, dto.getCertificateseq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 수상내역 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int AwardEdit(AwardDTO dto) {
		try {
			
			String sql ="update tblaward set awardname=?, getDate=?, agency=? where awardseq=?";
		
			pstat  = conn.prepareStatement(sql);
			pstat.setString(1, dto.getAwardname());
			pstat.setString(2, dto.getGetdate());
			pstat.setString(3, dto.getAgency());
			pstat.setString(4, dto.getAwardseq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 해외연수 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */

	public int AbroadEdit(AbroadDTO dto) {

		try {
				
				String sql ="update tblabroad set type=?, country=?, startdate=?, enddate=?, note=? where abroadseq=?";
			
				pstat  = conn.prepareStatement(sql);
				pstat.setString(1, dto.getType());
				pstat.setString(2, dto.getCountry());
				pstat.setString(3, dto.getStartDate());
				pstat.setString(4, dto.getEndDate());
				pstat.setString(5, dto.getNote());
				pstat.setString(6, dto.getAbroadseq());

				
				return pstat.executeUpdate();
				
			} catch (Exception e) {

				System.out.println(e);
			}
			return 0;
		
	}

	/***
	 * 포트폴리오 수정
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int portfolioEdit(PortfolioDTO dto) {
	try {	
		
		String sql ="update tblportfolio set url=?, filename=?, orgfilename=? where portfolioseq=?";
		
		pstat  = conn.prepareStatement(sql);
		pstat.setString(1, dto.getUrl());
		pstat.setString(2, dto.getFilename());
		pstat.setString(3, dto.getOrgfilename());
		pstat.setString(4, dto.getPortfolioseq());
		
		
		return pstat.executeUpdate();
		
	} catch (Exception e) {

		System.out.println(e);
	}
	return 0;

}	

	/***
	 * 이력서 삭제를위한 경력 삭제
	 * @author 혜승
	 * @param rseq
	 * @return
	 */
	public int rexperienceDelete(String rseq) {

		try {
			
			String sql = "delete from tblexperience where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/***
	 * 이력서 삭제위한 학력 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int reducationDelete(String rseq) {
		try {
			
			String sql = "delete from tbleducation where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	/***
	 * 이력서 삭제위한 자격증 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int rcertificateDelete(String rseq) {
		try {
			
			String sql = "delete from tblcertificate where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/***
	 * 이력서 삭제위한 수상 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int rawardDelete(String rseq) {
		try {
			
			String sql = "delete from tblaward where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

/***
	 * 이력서 삭제위한 대외활동 및 교육 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int rtrainingDelete(String rseq) {
		try {
			
			String sql = "delete from tbltraining where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 이력서 삭제위한 해외연수 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int rabroadDelete(String rseq) {
		try {
			
			String sql = "delete from tblabroad where resumeseq ="+rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


	/***
	 * 이력서 삭제위한 외국어 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int rlanguageDelete(String rseq) {
		try {
			
			String sql = "delete from tbllanguage where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * 이력서 삭제위한 포트폴리오 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int rportfolioDelete(String rseq) {
		try {
			
			String sql = "delete from tblportfolio where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/***
	 * 이력서 삭제
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public int resumeDelete(String rseq) {
		try {
			
			String sql = "delete from tblresume where resumeseq =" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/***
	 * profile에 있는 fk resume null로 업데이트
	 * @author 혜승
	 * @param rseq
	 * @return 
	 */
	public int profilenull(String rseq) {
		try {
			
			String sql = "update tblprofile set resumeseq='' where resumeseq=" + rseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
		
	}
	
}
