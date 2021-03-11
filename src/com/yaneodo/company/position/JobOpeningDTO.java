package com.yaneodo.company.position;

public class JobOpeningDTO {
	
	private String jobopeningseq;
	private String companyseq;
	private String title;
	private String startdate;
	private String enddate;
	private String job;
	private String place;
	private String description;
	private String photo;
	
	private String name; // 회사이름
	private String region; // 회사지역
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getJobopeningseq() {
		return jobopeningseq;
	}
	public void setJobopeningseq(String jobopeningseq) {
		this.jobopeningseq = jobopeningseq;
	}
	public String getCompanyseq() {
		return companyseq;
	}
	public void setCompanyseq(String companyseq) {
		this.companyseq = companyseq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
