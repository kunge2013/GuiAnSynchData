package com.keepsoft.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 道路
 * 建设项目海绵城市立项设计方案审查
 * @author admin
 *
 */
public class DESIGN_APPROVAL_SECOND implements Serializable{

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Date getAdmissibility_time() {
		return admissibility_time;
	}
	public void setAdmissibility_time(Date admissibility_time) {
		this.admissibility_time = admissibility_time;
	}
	public String getConstruct_unit() {
		return construct_unit;
	}
	public void setConstruct_unit(String construct_unit) {
		this.construct_unit = construct_unit;
	}
	public String getDesign_unit() {
		return design_unit;
	}
	public void setDesign_unit(String design_unit) {
		this.design_unit = design_unit;
	}
	public String getCensorship() {
		return censorship;
	}
	public void setCensorship(String censorship) {
		this.censorship = censorship;
	}
	public String getApproval_stage() {
		return approval_stage;
	}
	public void setApproval_stage(String approval_stage) {
		this.approval_stage = approval_stage;
	}
	public String getRelevant_archives() {
		return relevant_archives;
	}
	public void setRelevant_archives(String relevant_archives) {
		this.relevant_archives = relevant_archives;
	}
	public String getRoad_pro_ID() {
		return road_pro_ID;
	}
	public void setRoad_pro_ID(String road_pro_ID) {
		this.road_pro_ID = road_pro_ID;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -4389677600343298553L;
	private int	idx;//主键
	private Date admissibility_time;//受理时间
	private String construct_unit;//建设单位
	private String design_unit;//设计单位
	private String censorship;//审查机构
	private String approval_stage;//审批阶段
	private String relevant_archives;//审批相关档案
	private String road_pro_ID;//道路idx
	private String P;//url
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
}
