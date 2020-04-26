package org.woo.apt.file.domain;

public class FreeFileVO {
 private int ffno;
 private String title;
 private String content;
 private String userid;
 private String regdate;
 private String updatedate;

 
public int getFfno() {
	return ffno;
}
public void setFfno(int ffno) {
	this.ffno = ffno;
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
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
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
	return "FreeFileVO [ffno=" + ffno + ", title=" + title + ", content=" + content + ", userid=" + userid
			+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
}

 
}
