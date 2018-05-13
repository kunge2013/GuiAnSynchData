package com.keepsoft.domain;

public class EHR_USER {
	private Integer idx;
	private Integer emp_idx;
	private String name;
	private String pwd;
	
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public Integer getEmp_idx() {
		return emp_idx;
	}
	public void setEmp_idx(Integer emp_idx) {
		this.emp_idx = emp_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String code;

}
