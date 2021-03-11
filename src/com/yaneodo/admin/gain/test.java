package com.yaneodo.admin.gain;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

import com.yaneodo.DBUtil;

public class test {

	public static void main(String[] args) {
		
		

	
	try {
		
		for ( int i=0; i<50; i++) {
		Random rnd = new Random();
		
		int a = rnd.nextInt(75)+1;
		int b = rnd.nextInt(5)+1;
		int c = rnd.nextInt(3)+1;
		Connection conn = DBUtil.open(); 
		
		
		Statement stat = conn.createStatement();
		
		String sql = String.format("INSERT INTO tblPayment (paymentSeq, companyMemberSeq, serviceProductSeq, method, payDate) VALUES (paymentseq.nextVal, %d,%d,1, to_date('2021-03-%02d 15:36:02', 'YYYY-MM-DD HH24:MI:SS'))",a,b,c);
		
		stat.executeUpdate(sql);
		
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}