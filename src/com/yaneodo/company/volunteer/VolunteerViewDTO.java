package com.yaneodo.company.volunteer;

public class VolunteerViewDTO {
	
	private String aseq; // 지원 번호
	private String cmseq; // 기업 회원 번호
	private String name;
	private String email;
	private String phone;
	private String readdate; // 이력서 열람일자
	
	// 면접제안 정보들
	private String mseq; // 매치업 번호
	private String message;
	private String sgdate; // 제안 일자
	private String rank; 
	private String income;
	private String position;
	private String area;
	private String stock;
	private String state;
	
	private String rseq; // 프로필에 등록된 이력서 번호
	
	
	
	public String getRseq() {
		return rseq;
	}
	public void setRseq(String rseq) {
		this.rseq = rseq;
	}
	
	public String getReaddate() {
		return readdate;
	}
	public void setReaddate(String readdate) {
		this.readdate = readdate;
	}
	public String getAseq() {
		return aseq;
	}
	public void setAseq(String aseq) {
		this.aseq = aseq;
	}
	public String getCmseq() {
		return cmseq;
	}
	public void setCmseq(String cmseq) {
		this.cmseq = cmseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSgdate() {
		return sgdate;
	}
	public void setSgdate(String sgdate) {
		this.sgdate = sgdate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
