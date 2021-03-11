package com.yaneodo.member;

public class MemberDTO {
	
	private String customerSeq; //회원번호
	private String photo; //사진
	private String name; //이름
	private String nickName; //닉네임
	private String email; //이메일
	private String password; //비밀번호
	private String phone; //연락처
	private String birth; //생년월일
	private String gender; //성별
	private String joinDate; //가입일
	private String lastJoin; //마지막 접속일
	private String newpw; //새비밀번호
	
	
	//프로필 정보
	private String resumeSeq; //이력서번호
	private String profileSeq;
	private String jobSeq;
	private String isWorkSeq;
	private String school;
	private String major;
	private String company;
	private String career;
	private String introduction;
	
	
	public String getCustomerSeq() {
		return customerSeq;
	}
	public void setCustomerSeq(String customerSeq) {
		this.customerSeq = customerSeq;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getLastJoin() {
		return lastJoin;
	}
	public void setLastJoin(String lastJoin) {
		this.lastJoin = lastJoin;
	}
	public String getResumeSeq() {
		return resumeSeq;
	}
	public void setResumeSeq(String resumeSeq) {
		this.resumeSeq = resumeSeq;
	}
	public String getProfileSeq() {
		return profileSeq;
	}
	public void setProfileSeq(String profileSeq) {
		this.profileSeq = profileSeq;
	}
	public String getJobSeq() {
		return jobSeq;
	}
	public void setJobSeq(String jobSeq) {
		this.jobSeq = jobSeq;
	}
	public String getIsWorkSeq() {
		return isWorkSeq;
	}
	public void setIsWorkSeq(String isWorkSeq) {
		this.isWorkSeq = isWorkSeq;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}

	public String getNewpw() {
		return newpw;
	}
	public void setNewpw(String newpw) {
		this.newpw = newpw;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;

	}

}
