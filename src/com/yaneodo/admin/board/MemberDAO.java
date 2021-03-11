package com.yaneodo.admin.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.yaneodo.DBUtil;

import oracle.jdbc.OracleTypes;

public class MemberDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private CallableStatement cstat;
	private ResultSet rs;
	
	public MemberDAO() {
		
		//DB연결
		conn = DBUtil.open();
	}
	
	public void close() {
		
		try {
			
			conn.close();
			
		} catch (Exception e) {		
			System.out.println(e);			
		}
		
	}

	//MemberList 서블릿 > 멤버리스트 불러오기
	public ArrayList<MemberDTO> list(HashMap<String, String> map) {
		
		try {
			
			String sql = String.format("select * from (select rownum as rnum, c.* from (select * from tblCustomer) c) where rnum between %s and %s"
					, map.get("begin")
					, map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
			
			while (rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setPhoto(rs.getString("photo"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setJoinDate(rs.getString("joindate"));
				dto.setLastJoin(rs.getString("lastjoin"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("MemberDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}

	//MemberList 서블릿 > 멤버 리스트 개수 구하기
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql = "select count(*) as cnt from tblCustomer";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("MemberDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		
		return 0;
		
	}

	//Member 서블릿 > 멤버의 정보 불러오기
	public MemberDTO member(String seq) {
		
		try {
			
			String sql = "{ call procMember(?, ?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			ResultSet rs = (ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setCustomerSeq(rs.getString("customerseq"));
				dto.setPhoto(rs.getString("photo"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setBirth(rs.getString("birth"));
				dto.setJoinDate(rs.getString("joindate"));
				dto.setLastJoin(rs.getString("lastjoin"));
				dto.setLikeCnt(rs.getInt("likecnt"));
				dto.setBookMarkCnt(rs.getInt("bookmarkcnt"));
				dto.setBoardCnt(rs.getInt("boardcnt"));
				dto.setBoardCommentCnt(rs.getInt("boardcommentcnt"));
				dto.setQnaCnt(rs.getInt("qnacnt"));
				dto.setQnaCommentCnt(rs.getInt("qnacommentcnt"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("MemberDAO.member()");
			e.printStackTrace();
		}
		
		return null;
	}

	//Member 서블릿 > 멤버 이력서 정보 불러오기
	public ArrayList<MemberDTO> resume(String seq) {
		
		try {

			String sql = String.format("select * from tblResume where customerSeq = %s", seq);
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<MemberDTO> resumeList = new ArrayList<MemberDTO>();
			
			while (rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setResumeSeq(rs.getString("resumeSeq"));
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setOrgfilename(rs.getString("orgfileName"));
				dto.setIntroduce(rs.getString("introduce"));
				dto.setWriteDate(rs.getString("writedate"));
				dto.setEditDate(rs.getString("editdate"));
				
				resumeList.add(dto);
				
			}
			
			return resumeList;
			

		} catch (Exception e) {
			System.out.println("MemberDAO.resume()");
			e.printStackTrace();
		}
		
		return null;
	}

}




















