package com.yaneodo.company.match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.yaneodo.DBUtil;
import com.yaneodo.member.profile.ProfileDTO;
import com.yaneodo.member.resume.ResumeDetailDTO;

public class MatchDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MatchDAO() {
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

	/**
	 * match/list 서블릿에서 요청 프로필 목록을 리턴하는 메서드
	 * @param map 
	 * @return 
	 */
	public ArrayList<ProfileDTO> listProfile(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			int count = map.size();
			System.out.println("listProfile map.size() : " + map.size());
		
			if (map.size() > 3) {
				where = "where ";
			}
			
			if (map.get("search") != null) {
				// 검색어가 있을때 > 검색중일때
				where += String.format("(jobtype like '%%%s%%' or company like '%%%s%%' or major like '%%%s%%' or school like '%%%s%%')", map.get("search"), map.get("search"), map.get("search"), map.get("search") );
				count--;
			}
			
			if (map.get("jobtype") != null) {
				// 직무가 선택되었을때 
				if (count == map.size()) {
					where += String.format(" jobtype = '%s'", map.get("jobtype"));
					count--;
				} else {
					where += String.format(" and jobtype = '%s'", map.get("jobtype"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			if (map.get("isdibs") != null) {
				// 찜목록 선택되었을때 
				if (count == map.size()) {
					where += String.format(" profileseq in (select profileseq from tbldibs where companymemberseq = '%s')", map.get("session"));
					count--;
				} else {
					where += String.format(" and profileseq in (select profileseq from tbldibs where companymemberseq = '%s')", map.get("session"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			
			
			if (map.get("isread") != null) {
				
				if (map.get("isread").equals("1")) {
					// 열람한목록 선택되었을때 
					if (count == map.size()) {
						where += String.format(" profileseq in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
						count--;
					} else {
						where += String.format(" and profileseq in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
					}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
				} else {
					// 미열람목록 선택되었을때
					if (count == map.size()) {
						where += String.format(" profileseq not in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
						count--;
					} else {
						where += String.format(" and profileseq not in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
					}	        					
				}
			}
			
			
			if (map.get("ismatch") != null) {
				// 면접제안 목록
				if (count == map.size()) {
					where += String.format(" profileseq in (select profileseq from tblresumeread rr inner join tblmatchup m on rr.resumereadseq = m.resumereadseq where rr.companymemberseq = %s)", map.get("session"));
					count--;
				} else {
					where += String.format(" and profileseq in (select profileseq from tblresumeread rr inner join tblmatchup m on rr.resumereadseq = m.resumereadseq where rr.companymemberseq = %s)", map.get("session"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			//페이징 이전 쿼리
			//String sql = String.format("select * from vwMatchList %s", where);
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwMatchList %s order by profileseq desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			System.out.println(sql);
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<ProfileDTO> list = new ArrayList<ProfileDTO>();
			
			while (rs.next()) {
				ProfileDTO dto = new ProfileDTO();
				
				dto.setProfileseq(rs.getString("profileseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setJobtype(rs.getString("jobtype"));
				dto.setSchool(rs.getString("school"));
				dto.setMajor(rs.getString("major"));
				dto.setCompany(rs.getString("company"));
				dto.setCareer(rs.getString("career"));
				dto.setIntroduction(rs.getString("introduction"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * match/list 서블릿에서 요청 직무의 종류를 리턴하는 메서드
	 * @return
	 */
	public ArrayList<String> listJob() {
		
		try {
			
			String sql = "select type from tblJob";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<String> list = new ArrayList<String>();
			
			while (rs.next()) {
				list.add(rs.getString("type"));
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * match/list 서블릿에서 프로필의 총 개수를 리턴
	 * @return
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			int count = map.size();
			System.out.println("getTotalCount map.size() : " + map.size());
		
			if (map.size() > 3) {
				where = "where ";
			}
			
			if (map.get("search") != null) {
				// 검색어가 있을때 > 검색중일때
				where += String.format("(jobtype like '%%%s%%' or company like '%%%s%%' or major like '%%%s%%' or school like '%%%s%%')", map.get("search"), map.get("search"), map.get("search"), map.get("search") );
				count--;
			}
			
			if (map.get("jobtype") != null) {
				// 직무가 선택되었을때 
				if (count == map.size()) {
					where += String.format(" jobtype = '%s'", map.get("jobtype"));
					count--;
				} else {
					where += String.format(" and jobtype = '%s'", map.get("jobtype"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			if (map.get("isdibs") != null) {
				// 찜목록 선택되었을때 
				if (count == map.size()) {
					where += String.format(" profileseq in (select profileseq from tbldibs where companymemberseq = '%s')", map.get("session"));
					count--;
				} else {
					where += String.format(" and profileseq in (select profileseq from tbldibs where companymemberseq = '%s')", map.get("session"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			
			
			if (map.get("isread") != null) {
				
				if (map.get("isread").equals("1")) {
					// 열람한목록 선택되었을때 
					if (count == map.size()) {
						where += String.format(" profileseq in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
						count--;
					} else {
						where += String.format(" and profileseq in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
					}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
				} else {
					// 미열람목록 선택되었을때
					if (count == map.size()) {
						where += String.format(" profileseq not in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
						count--;
					} else {
						where += String.format(" and profileseq not in (select profileseq from tblresumeread where companymemberseq = '%s')", map.get("session"));
					}	        					
				}
			}
			
			
			if (map.get("ismatch") != null) {
				// 면접제안 목록
				if (count == map.size()) {
					where += String.format(" profileseq in (select profileseq from tblresumeread rr inner join tblmatchup m on rr.resumereadseq = m.resumereadseq where rr.companymemberseq = %s)", map.get("session"));
					count--;
				} else {
					where += String.format(" and profileseq in (select profileseq from tblresumeread rr inner join tblmatchup m on rr.resumereadseq = m.resumereadseq where rr.companymemberseq = %s)", map.get("session"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			String sql = String.format("select count(*) as cnt from vwMatchList %s", where);
			
			System.out.println(sql);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/**
	 * 프로필 번호로 해당 프로필의 모든 정보를 반환하는 메서드
	 * @param pseq 프로필 번호
	 * @return
	 */
	public ResumeDetailDTO getResumeDetail(String pseq) {
		
		try {
			
			String sql = "select * from vwResumeDetail where profileseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pseq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				ResumeDetailDTO dto = new ResumeDetailDTO();
				
				dto.setProfileseq(rs.getString("profileseq"));
				dto.setResumeseq(rs.getString("resumeseq"));
				dto.setJobtype(rs.getString("jobtype"));
				dto.setSchool(rs.getString("school"));
				dto.setMajor(rs.getString("major"));
				dto.setCompany(rs.getString("company"));
				dto.setCareer(rs.getString("career"));
				dto.setIntroduction(rs.getString("introduction"));
				
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				
				
				return dto;
				
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		return null;
	}

	/**
	 * 찜하기를 등록하는 메서드
	 * @param pseq 프로필번호
	 * @param session 기업 회원 seq
	 * @return
	 */
	public int addDibs(String pseq, String session) {
		
		try {

			String sql = "insert into tblDibs(dibsSeq, profileSeq, companyMemberSeq, dibDate) values (DIBSSEQ.nextval, ?, ?, sysdate)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pseq);
			pstat.setString(2, session);

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0;
	}

	/**
	 * 찜하기를 취소하는 메서드
	 * @param pseq 프로필번호
	 * @param session 기업 회원 seq
	 * @return
	 */
	public int deleteDibs(String pseq, String session) {
		try {

			String sql = "delete from tblDibs where profileseq = ? and companymemberseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pseq);
			pstat.setString(2, session);

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0;
	}
	
	
	/**
	 * 찜목록 리스트를 가져오는 메서드
	 * @param tempSession 기업회원 번호
	 * @return
	 */
	public ArrayList<DibsDTO> listDibs(String session) {
		
		try {
			
			String sql = "select * from tblDibs where companyMemberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, session);
			
			rs = pstat.executeQuery();
			
			ArrayList<DibsDTO> list = new ArrayList<DibsDTO>();
			
			while (rs.next()) {
				DibsDTO dto = new DibsDTO();
				
				dto.setDibsseq(rs.getString("dibsseq"));
				dto.setProfileseq(rs.getString("profileseq"));
				dto.setCompanyMemberseq(rs.getString("companymemberseq"));
				dto.setDibdate(rs.getString("dibdate"));
				
				list.add(dto);
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	/**
	 * 열람한 목록 리스트를 가져오는 메서드
	 * @param tempSession 기업회원 번호
	 * @return
	 */
	public ArrayList<ResumeReadDTO> listRead(String session) {
		
		try {
			
			String sql = "select * from tblResumeRead where companyMemberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, session);
			
			rs = pstat.executeQuery();
			
			ArrayList<ResumeReadDTO> list = new ArrayList<ResumeReadDTO>();
			
			while (rs.next()) {
				ResumeReadDTO dto = new ResumeReadDTO();
				
				dto.setResumereadseq(rs.getString("resumereadseq"));
				dto.setProfileseq(rs.getString("profileseq"));
				dto.setCompanymemberseq(rs.getString("companymemberseq"));
				dto.setReaddate(rs.getString("readdate"));
				
				list.add(dto);
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	/**
	 * 면접제안 목록 리스트를 가져오는 메서드
	 * @param tempSession 기업회원 번호
	 * @return
	 */
	public ArrayList<MatchupDTO> listMatchup(String session) {
		
		try {
			
			String sql = "select m.*, (select profileseq from tblResumeRead where resumereadseq = m.resumereadseq) as profileseq from tblMatchup m where m.resumeReadSeq in (select resumereadseq from tblResumeRead where companyMemberSeq = ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, session);
			
			rs = pstat.executeQuery();
			
			ArrayList<MatchupDTO> list = new ArrayList<MatchupDTO>();
			
			while (rs.next()) {
				MatchupDTO dto = new MatchupDTO();
				
				dto.setMatchupseq(rs.getString("matchupseq"));
				dto.setResumereadseq(rs.getString("resumereadseq"));
				dto.setMessage(rs.getString("message"));
				dto.setSuggestdate(rs.getString("suggestdate"));
				dto.setRank(rs.getString("rank"));
				dto.setIncome(rs.getString("income"));
				dto.setPosition(rs.getString("position"));
				dto.setArea(rs.getString("area"));
				dto.setStockoption(rs.getString("stockoption"));
				dto.setState(rs.getString("state"));
				dto.setProfileseq(rs.getString("profileseq"));
				
				
				list.add(dto);
				
			}
			
			return list;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/**
	 * 보유한 열람권 개수 리턴
	 * @param session 기업회원번호
	 * @return
	 */
	public String getPassCount(String session) {
		
		try {
			
			String sql = "Select pass from tblCompanyMember where companyMemberSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, session);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("pass");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * 열람권 개수 - 1
	 * @param tempsession
	 */
	public void updatePassCount(String session) {
		
		try {
			
			String sql = "update tblcompanyMember set pass = pass - 1 where companymemberseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, session);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * 열람 목록에 추가(읽은 이력서)
	 * @param tempsession
	 * @param pseq 
	 */
	public void AddResumeRead(String session, String pseq) {
		
		try {
	
			String sql = "insert into tblResumeRead (resumereadseq, profileseq, companymemberseq, readDate) values (resumeReadSeq.nextVal, ?, ?, sysdate)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pseq);
			pstat.setString(2, session);
			
			pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}


}



















