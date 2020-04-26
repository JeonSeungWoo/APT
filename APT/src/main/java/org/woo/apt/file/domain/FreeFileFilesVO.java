package org.woo.apt.file.domain;

public class FreeFileFilesVO {
	private int fffno;
	private int ffno;
	private String path;
	private String filename;
	private String regdate;
	private String updatedate;
	public int getFffno() {
		return fffno;
	}
	public void setFffno(int fffno) {
		this.fffno = fffno;
	}
	public int getFfno() {
		return ffno;
	}
	public void setFfno(int ffno) {
		this.ffno = ffno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
		return "FreeFileFilesVO [fffno=" + fffno + ", ffno=" + ffno + ", path=" + path + ", filename=" + filename
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
}
