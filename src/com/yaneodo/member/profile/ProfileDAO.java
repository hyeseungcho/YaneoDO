package com.yaneodo.member.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yaneodo.DBUtil;
import com.yaneodo.member.MemberDTO;

public class ProfileDAO {
	
	
	
	private Connection conn;
	private Statement stat; 
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ProfileDAO() {

		conn = DBUtil.open();
	}


	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	//프로필 View -> 회원 프로필정보 반환
	public MemberDTO getProfile(String seq) {
		
		try {
			
			String sql = "select * from vwProfile where customerSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setProfileSeq(rs.getString("profileSeq"));
				dto.setResumeSeq(rs.getString("resumeSeq"));
				dto.setJobSeq(rs.getString("jobSeq"));
				dto.setIsWorkSeq(rs.getString("isWorkSeq"));
				dto.setSchool(rs.getString("school"));
				dto.setMajor(rs.getString("major"));
				dto.setCompany(rs.getString("company"));
				dto.setCareer(rs.getString("career"));
				dto.setIntroduction(rs.getString("introduction"));
				
				//회원번호, 회원이름
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setName(rs.getString("customerName"));
				
			
	
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}


	// 프로필 EditOk -> 프로필수정
	public int editProfile(MemberDTO dto) {
		
		try {
			
			String sql = "update tblProfile p set school = ?, major = ?, company = ?, introduction = ? "
					+ "  where (select r.customerSeq from tblResume r where p.resumeSeq = r.resumeSeq) = ?"; //이력서번호로 회원번호찾아야함
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSchool());
			pstat.setString(2, dto.getMajor());
			pstat.setString(3, dto.getCompany());
			pstat.setString(4, dto.getIntroduction());
			
			pstat.setString(5, dto.getCustomerSeq()); //회원번호
			
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} 
	
		return 0;
	}


	//공고지원하기 ApplyOk -> 기본이력서 변경
	public int editBasicResume(MemberDTO dto) {
		
	try {
			
			String sql = "update tblProfile set resumeSeq = ? "
							+ "where profileSeq = (select profileSeq from tblProfile "
								+ "where resumeSeq = (select resumeSeq from vwBasicResume where customerSeq= ? ))"; 
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getResumeSeq());
			pstat.setString(2, dto.getCustomerSeq()); //회원번호
			
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} 
	
		
		return 0;
	}
	

	
	

}
