package com.yaneodo.admin.gain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.yaneodo.DBUtil;

public class GainDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public GainDAO() {
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

	public GainDTO getgainday(String date) {

		//String days = "2021/02/02";
		String days = date.substring(2,4) +"/"+ date.substring(5,7)+"/"+date.substring(8);
		
		try {
			
			String sql = "select Atype, Btype, Ctype, Dtype, Etype, (Atype *100000+Btype*200000+Ctype*300000+Dtype*400000+Etype*500000) as sum from (select count(case when sp.type = 'a상품' then 1 end) as Atype, count(case when sp.type = 'b상품' then 1 end) as Btype, count(case when sp.type = 'c상품' then 1 end) as Ctype, count(case when sp.type = 'd상품' then 1 end) as Dtype, count(case when sp.type = 'e상품' then 1 end) as Etype from tblServiceproduct sp inner join tblPayment pm on sp.serviceProductSeq = pm.serviceProductSeq where to_char(pm.paydate,'yy/mm/dd') = ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, days);
			
			rs = pstat.executeQuery();
			
			
		
			
			GainDTO dto = new GainDTO();

			if(rs.next()) {
			
				dto.setA(rs.getString("Atype"));
				dto.setB(rs.getString("Btype"));
				dto.setC(rs.getString("Ctype"));
				dto.setD(rs.getString("Dtype"));
				dto.setE(rs.getString("Etype"));
						
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	public GainDTO getgainweek(String date) {
		
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
			
			String sql = "select Atype, Btype, Ctype, Dtype, Etype, (Atype *100000+Btype*200000+Ctype*300000+Dtype*400000+Etype*500000) as sum from (select count(case when sp.type = 'a상품' then 1 end) as Atype, count(case when sp.type = 'b상품' then 1 end) as Btype, count(case when sp.type = 'c상품' then 1 end) as Ctype, count(case when sp.type = 'd상품' then 1 end) as Dtype, count(case when sp.type = 'e상품' then 1 end) as Etype from tblServiceproduct sp inner join tblPayment pm on sp.serviceProductSeq = pm.serviceProductSeq where to_char(pm.paydate,'yy/mm/dd') between ? and ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, daystart);
			pstat.setString(2, dayend);
			
			rs = pstat.executeQuery();
			
						
			GainDTO dto = new GainDTO();

			if(rs.next()) {
			
				dto.setA(rs.getString("Atype"));
				dto.setB(rs.getString("Btype"));
				dto.setC(rs.getString("Ctype"));
				dto.setD(rs.getString("Dtype"));
				dto.setE(rs.getString("Etype"));
						
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	public GainDTO getgainmonth(String date) {
Calendar cal = Calendar.getInstance();
		
		String daystart = "";
		String dayend = date.substring(2,4) +"/"+ date.substring(5,7)+"/"+date.substring(8);
		
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = formatter.parse(date);
			cal.setTime(dates);
			cal.add(Calendar.DATE, -30);
			
			String end = String.format("%tF", cal);
			
			daystart = end.substring(2,4) +"/"+ end.substring(5,7)+"/"+end.substring(8);
			
			String sql = "select Atype, Btype, Ctype, Dtype, Etype, (Atype *100000+Btype*200000+Ctype*300000+Dtype*400000+Etype*500000) as sum from (select count(case when sp.type = 'a상품' then 1 end) as Atype, count(case when sp.type = 'b상품' then 1 end) as Btype, count(case when sp.type = 'c상품' then 1 end) as Ctype, count(case when sp.type = 'd상품' then 1 end) as Dtype, count(case when sp.type = 'e상품' then 1 end) as Etype from tblServiceproduct sp inner join tblPayment pm on sp.serviceProductSeq = pm.serviceProductSeq where to_char(pm.paydate,'yy/mm/dd') between ? and ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, daystart);
			pstat.setString(2, dayend);
			
			rs = pstat.executeQuery();
			
						
			GainDTO dto = new GainDTO();

			if(rs.next()) {
			
				dto.setA(rs.getString("Atype"));
				dto.setB(rs.getString("Btype"));
				dto.setC(rs.getString("Ctype"));
				dto.setD(rs.getString("Dtype"));
				dto.setE(rs.getString("Etype"));
						
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
