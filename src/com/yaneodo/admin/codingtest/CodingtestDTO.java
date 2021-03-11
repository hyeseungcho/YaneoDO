package com.yaneodo.admin.codingtest;

public class CodingtestDTO {

	private String seq;
	private String name;
	
	private String frequency; //출제빈도
	private String type; //유형
	private String language;
	private String question; //문제
	private String answer; //정답
	private String difficulty;
	

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	private String lines; //사용자의 풀이 / 문제등록여부


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

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getLines() {
		return lines;
	}

	public void setLines(String lines) {
		this.lines = lines;
	}
	
}
