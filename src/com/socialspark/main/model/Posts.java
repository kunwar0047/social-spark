package com.socialspark.main.model;
import java.sql.Date;


public class Posts {

	public int pid;
	String ptitle;
	String pbody;
	java.sql.Date pdate;
	String uname;
	public int plikes;
	public int getPlikes() {
		return plikes;
	}
	public void setPlikes(int plikes) {
		this.plikes = plikes;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPbody() {
		return pbody;
	}
	public void setPbody(String pbody) {
		this.pbody = pbody;
	}
	public java.sql.Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Posts(int pid, String uname, String ptitle, String pbody,int plikes) {
		super();
		this.pid = pid;
		this.plikes = plikes;
		this.ptitle = ptitle;
		this.pbody = pbody;
//		this.pdate = pdate;
		this.uname = uname;
		
	}

}