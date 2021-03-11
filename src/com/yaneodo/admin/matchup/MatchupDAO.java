package com.yaneodo.admin.matchup;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.yaneodo.DBUtil;

import oracle.jdbc.OracleTypes;

public class MatchupDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;
	
	public MatchupDAO() {
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


	public String getgaintoday(String date) {
		
		String days = date.substring(2,4) +"/"+ date.substring(5,7)+"/"+date.substring(8);
		
		
		
		try {
			
			String sql = "select count(*) as count from tblmatchup where to_char(suggestdate,'yy/mm/dd') = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, days);
			
			rs = pstat.executeQuery();
		
			
			

			if(rs.next()) {
			
				String today = rs.getString("count");
						
				return today;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	public String getgainyest(String date) {
Calendar cal = Calendar.getInstance();
		
		String days = "";
		
		
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = formatter.parse(date);
			cal.setTime(dates);
			cal.add(Calendar.DATE, -1);
			
			String end = String.format("%tF", cal);
			
			days = end.substring(2,4) +"/"+ end.substring(5,7)+"/"+end.substring(8);
			
			String sql = "select count(*) as count from tblmatchup where to_char(suggestdate,'yy/mm/dd') = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, days);
			
			
			rs = pstat.executeQuery();
			
						
			if(rs.next()) {
				
				String yest = rs.getString("count");
						
				return yest;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	public String getgainweek(String date) {
		
		Calendar cal = Calendar.getInstance();
		
		String daystart = "";
		String dayend = date.substring(2,4) +"/"+ date.substring(5,7)+"/"+date.substring(8);
		
		
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = formatter.parse(date);
			cal.setTime(dates);
			cal.add(Calendar.DATE, -7);
			
			String end = String.format("%tF", cal);
			
			daystart = end.substring(2,4) +"/"+ end.substring(5,7)+"/"+end.substring(8);
			
			String sql = "select count(*) as count from tblmatchup where to_char(suggestdate,'yy/mm/dd') between ? and ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, daystart);
			pstat.setString(2, dayend);
			
			rs = pstat.executeQuery();
			
						
			if(rs.next()) {
				
				String week = rs.getString("count");
						
				return week;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	//Matchup member -> 회원의 매치업정보 가져오기
	public ArrayList<MatchupDTO> getmemberlist(int all) {
		
		try {
			
			ArrayList<MatchupDTO> list = new ArrayList<MatchupDTO>();
			
			for (int i =1; i<=all; i++) {
		
				String sql = "{ call procmatchupmember(?,?)}";
				
				cstat = conn.prepareCall(sql);
				
				cstat.setInt(1,i);		
				cstat.registerOutParameter(2, OracleTypes.CURSOR);
				cstat.executeQuery();
				
				rs = (ResultSet)cstat.getObject(2);
				
				
				if(rs.next()) {
					
					MatchupDTO dto = new MatchupDTO();
					
					dto.setSeq(i+"");
					dto.setName(rs.getString("name"));
					dto.setSuggest(rs.getString("sug"));
					dto.setIng(rs.getString("ing"));
					dto.setSuccess(rs.getString("suc"));
					dto.setAgree(rs.getString("agree"));
					
					list.add(dto);
				}
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	//member의 수 가져오기
	public int getcount() {
		
		try {
			
			String sql = "select count(*) as cnt from tblcustomer";
			
			stat = conn.createStatement();
			
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


	public int getcompanycount() {
try {
			
			String sql = "select count(*) as cnt from tblcompanymember";
			
			stat = conn.createStatement();
			
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


	//기업회원 매치업 정보 가져오기
	public ArrayList<MatchupDTO> getcompanylist(int all) {
		
		try {
			
			ArrayList<MatchupDTO> list = new ArrayList<MatchupDTO>();
			
			for (int i =1; i<=all; i++) {
		
				String sql = "{ call procmatchupcompany(?,?)}";
				
				cstat = conn.prepareCall(sql);
				
				cstat.setInt(1,i);		
				cstat.registerOutParameter(2, OracleTypes.CURSOR);
				cstat.executeQuery();
				
				rs = (ResultSet)cstat.getObject(2);
				
				
				if(rs.next()) {
					
					MatchupDTO dto = new MatchupDTO();
					
					dto.setSeq(i+"");
					dto.setName(rs.getString("name"));
					dto.setRead(rs.getString("use"));
					dto.setInter(rs.getString("inter"));
					dto.setSuggest(rs.getString("sug"));
					dto.setIng(rs.getString("ing"));
					dto.setSuccess(rs.getString("suc"));
					
					list.add(dto);
				}
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
