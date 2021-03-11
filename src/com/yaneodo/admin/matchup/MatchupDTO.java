package com.yaneodo.admin.matchup;

public class MatchupDTO {

	//메인
	private String today;
	private String yest;
	private String week;
	
	//회원
	private String seq;
	private String name;
	private String suggest;
	private String agree;
	private String ing;
	
	//기업
	private String read;
	private String inter;

	
	

	public String getInter() {
		return inter;
	}
	public void setInter(String inter) {
		this.inter = inter;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	private String success;
	
	
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getYest() {
		return yest;
	}
	public void setYest(String yest) {
		this.yest = yest;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	

}
