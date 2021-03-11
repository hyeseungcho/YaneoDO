package com.yaneodo.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yaneodo.DBUtil;


public class MemberDAO {
	
	private Connection conn;
	private Statement stat; 
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MemberDAO() {

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
	 * 회원정보반환
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public MemberDTO get(String seq) {
		
		try {
			
			String sql = "select * from tblCustomer where customerSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setPhoto(rs.getString("photo"));
				dto.setName(rs.getString("name"));
				dto.setNickName(rs.getString("nickName"));
				dto.setEmail(rs.getString("email"));
				dto.setPassword(rs.getString("password"));
				dto.setPhone(rs.getString("phone"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setJoinDate(rs.getString("joinDate"));
				dto.setLastJoin(rs.getString("lastJoin"));
				
	
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}		return null;
	}
	

  
	
	/***
	 * Customer_editOk 서블릿 -> 회원정보수정
	 * @author 혜승
	 * @param dto
	 * @param seq
	 * @return
	 */
	public int edit(MemberDTO dto, String seq) {
		try {
			
			String sql ="update tblCustomer set name=?, nickName=?, birth=?, phone=? where customerseq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getNickName());
			pstat.setString(3, dto.getBirth());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, seq);
			
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


	/***
	 * Customer_edit 서블릿 -> 회원정보가져오기
	 * @author 혜승
	 * @param seq
	 * @return
	 */
	public MemberDTO getInfo(String seq) {
		try {
			
			String sql = "select * from tblCustomer where customerSeq =?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setNickName(rs.getString("nickName"));
				dto.setPhone(rs.getString("phone"));
				dto.setPassword(rs.getString("password"));
				dto.setPhoto(rs.getString("photo"));
				dto.setEmail(rs.getString("email"));
				dto.setCustomerSeq(rs.getString("customerSeq"));
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/***
	 * Customer_edit 닉네임중복검사
	 * @author 혜승
	 * @param nickName
	 * @return
	 */
	public int checkNick(String nickName) {
		try {
			String sql = "select count(*) as cnt from tblCustomer where nickName=? ";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, nickName);
			
			rs = pstat.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}




	
	//Login servlet -> 로그인 요청
	public int login(MemberDTO dto) {
		
		try {
			
			String sql = "select count(*) as cnt from tblCustomer where email = ? and password = ?";
			//String sql = "select count(*) as cnt from tblCustomer where email = 'mun7617@naver.com' and password = 'kownjuhong9325'";
			
//			stat = conn.createStatement();
//			rs = stat.executeQuery(sql);
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getEmail());
			pstat.setString(2, dto.getPassword());
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}	
		
		return 0;
		
	}
	
	//Login servlet -> 회원정보 요청
	public MemberDTO getMember(String email) {
		
		try {
			
			String sql = "select * from tblCustomer where email = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, email);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				
				dto.setCustomerSeq(rs.getString("customerSeq"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoto(rs.getString("photo"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setNickName(rs.getString("nickName"));
				dto.setLastJoin(rs.getString("lastJoin"));
				dto.setPassword(rs.getString("password"));
				
				return dto;
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	//RegisterOk -> 회원가입 요청 
	public int add(MemberDTO dto) {
		
		try {
			
			String sql = "insert into tblCustomer(customerSeq, name, nickName, email, phone, birth, gender, password, joinDate, lastJoin) "
					+ "values (customerSeq.nextVal, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getNickName());
			pstat.setString(3, dto.getEmail());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getBirth());
			pstat.setString(6, dto.getGender());
			pstat.setString(7, dto.getPassword());

			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0;
	}


	/***
	 * 비밀번호 수정 
	 * @author 혜승
	 * @param dto
	 * @return
	 */
	public int checkPW(MemberDTO dto) {
		try {
			
			String sql ="update tblCustomer set password=? where customerseq=? and password=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getNewpw());
			pstat.setString(2, dto.getCustomerSeq());
			pstat.setString(3, dto.getPassword());
			
			return pstat.executeUpdate();

			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


/***
 * 회원탈퇴
 * @author 혜승
 * @param seq
 * @return
 */
	public int delaccount(String seq) {
		
		try {
			
			String sql = "update tblCustomer set photo='', name='', nickname='', email='', phone='', birth='', gender='',password='', joindate='', lastjoin='' where customerseq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
				
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


/***
 * 회원사진올리기
 * @author 혜승
 * @param dto
 * @param seq
 * @return
 */
public int photoEdit(MemberDTO dto) {
	try {
		
		String sql = "update tblcustomer set photo =? where customerseq = ?";
		
		pstat= conn.prepareStatement(sql);
		pstat.setString(1, dto.getPhoto());
		pstat.setString(2, dto.getCustomerSeq());
		
		return pstat.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return 0;
}



	
	
	
}




