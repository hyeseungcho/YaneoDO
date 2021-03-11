package com.yaneodo.company.volunteer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.yaneodo.DBUtil;


public class VolunteerDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public VolunteerDAO() {
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

	// List 서블릿에서 지원자 목록을 리턴받는다
	public ArrayList<VolunteerDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			System.out.println("map의 크기" + map.size());
			int count = map.size();
			
			if (map.size() > 0 ) {
				where = "where ";
			}
			
			if (map.get("search") != null) {
				// 검색어가 있을때 > 검색중일때
				where += String.format("(name like '%%%s%%' or job like '%%%s%%')", map.get("search"), map.get("search"));
				count--;
			}
			
			if (map.get("isread") != null) {
				// 매치업 탭을 클릭했을때 
				if (count == map.size()) {
					where += String.format(" isread = '%s'", map.get("isread"));
					count--;
				} else {
					where += String.format(" and isread = '%s'", map.get("isread"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			if (map.get("session") != null) {
				if (count == map.size()) {
					where += String.format(" cmseq = '%s'", map.get("session"));	
					count--;
				} else {
					where += String.format(" and cmseq = '%s'", map.get("session"));
				}	          
			}
			
			if (map.get("job") != null) {
				if (count == map.size()) {
					where += String.format("job = '%s'", map.get("job"));	
					count--;
				} else {
					where += String.format(" and job = '%s'", map.get("job"));
				}	          
			}
			
			// 페이징 이전 쿼리
//			String sql = String.format("select * from vwVolunteer %s order by pseq desc", where);
			
//			select * from (select rownum as rnum, a.* from (select * from vwVolunteer order by pseq desc) a) where rnum between 1 and 5;
			
			String sql = String.format("select * from (select rownum as rnum, a.* from (select * from vwVolunteer %s order by aseq desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			
			System.out.println(sql);
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<VolunteerDTO> list = new ArrayList<VolunteerDTO>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				VolunteerDTO dto = new VolunteerDTO();
				
				dto.setPseq(rs.getString("pseq"));
				dto.setAseq(rs.getString("aseq"));
				dto.setCmseq(rs.getString("cmseq"));
				dto.setName(rs.getString("name"));
				dto.setJob(rs.getString("job"));
				dto.setIsread(rs.getString("isread"));
				dto.setIsdibs(rs.getString("isdibs"));
				dto.setAsseq(rs.getString("asseq"));
				
				
				list.add(dto);
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	//  List 서블릿에서 사이드메뉴 공고직종 목록을 리턴받는다
	public ArrayList<String> mlist(String cmseq) {
		
		try {
			
			String sql = "select jo.job as job from tblCompany cp inner join tbljobopening jo on cp.companyseq = jo.companyseq where cp.companymemberseq = ?";
			
//			System.out.println(sql);
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, cmseq);
			
			rs = pstat.executeQuery();
			
			//ResultSet -> ArrayList<DTO>
			ArrayList<String> list = new ArrayList<String>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				String menu = rs.getString("job");

				list.add(menu);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	//List 서블릿에서 지원자의 총 개수를 리턴
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			/*
			 * String where = "";
			 * 
			 * if (map.get("search") != null) { // 검색어가 있을때 > 검색중일때 where +=
			 * String.format("where (name like '%%%s%%' or job like '%%%s%%')",
			 * map.get("search"), map.get("search")); where +=
			 * String.format(" and cmseq = '%s'", map.get("session")); } else { where +=
			 * String.format("where  cmseq = '%s'", map.get("session")); }
			 * 
			 * String sql = String.format("select count(*) as cnt from vwVolunteer %s",
			 * where);
			 */
			
			String where = "";
			
			System.out.println("map의 크기" + map.size());
			int count = map.size();
			
			if (map.size() > 0 ) {
				where = "where ";
			}
			
			if (map.get("search") != null) {
				// 검색어가 있을때 > 검색중일때
				where += String.format("(name like '%%%s%%' or job like '%%%s%%')", map.get("search"), map.get("search"));
				count--;
			}
			
			if (map.get("isread") != null) {
				// 매치업 탭을 클릭했을때 
				if (count == map.size()) {
					where += String.format(" isread = '%s'", map.get("isread"));
					count--;
				} else {
					where += String.format(" and isread = '%s'", map.get("isread"));
				}	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			}
			
			if (map.get("session") != null) {
				if (count == map.size()) {
					where += String.format(" cmseq = '%s'", map.get("session"));	
					count--;
				} else {
					where += String.format(" and cmseq = '%s'", map.get("session"));
				}	          
			}
			
			if (map.get("job") != null) {
				if (count == map.size()) {
					where += String.format("job = '%s'", map.get("job"));	
					count--;
				} else {
					where += String.format(" and job = '%s'", map.get("job"));
				}	          
			}
			
			String sql = String.format("select count(*) as cnt from vwVolunteer %s", where);
			
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

	
	// View 서블릿 에서 요청 한명의 view페이지 정보를 반환한다
	public VolunteerViewDTO getView(String aseq, String cmseq) {
		
		try {
			
			String sql = "select * from vwVolunteerView where aseq = ? and cmseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, aseq);
			pstat.setString(2, cmseq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				VolunteerViewDTO dto = new VolunteerViewDTO();
				
				dto.setAseq(rs.getString("aseq"));
				dto.setCmseq(rs.getString("cmseq"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setReaddate(rs.getString("readdate"));
				
				dto.setMseq(rs.getString("mseq"));
				dto.setMessage(rs.getString("message"));
				dto.setSgdate(rs.getString("sgdate"));
				dto.setRank(rs.getString("rank"));
				dto.setIncome(rs.getString("income"));
				dto.setPosition(rs.getString("position"));
				dto.setArea(rs.getString("area"));
				dto.setStock(rs.getString("stock"));
				dto.setState(rs.getString("state"));
				
				dto.setRseq(rs.getString("rseq")); // 이력서 번호
				System.out.println("이력서 번호 : " + dto.getRseq());
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}



















