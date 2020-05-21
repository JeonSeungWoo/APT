package org.woo.apt.service.domain;

public class ServiceVO {
	private int sno;
	private String title;
	private String content;
	private String answer;
	private String writer;
	
	private String respondent;
	private int answerYN;
	private String regdate;
	private String updatedate;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRespondent() {
		return respondent;
	}
	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}
	public int getAnswerYN() {
		return answerYN;
	}
	public void setAnswerYN(int answerYN) {
		this.answerYN = answerYN;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ServiceVO [sno=" + sno + ", title=" + title + ", content=" + content + ", answer=" + answer
				+ ", writer=" + writer + ", respondent=" + respondent + ", answerYN=" + answerYN + ", regdate="
				+ regdate + ", updatedate=" + updatedate + "]";
	}
	
	
	
}
