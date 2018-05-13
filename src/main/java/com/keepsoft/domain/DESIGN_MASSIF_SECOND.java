package com.keepsoft.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 地块
 * 建设项目海绵城市立项设计方案审查
 * @author admin
 *
 */
public class DESIGN_MASSIF_SECOND implements Serializable {
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
	public String getMassif_idx() {
		return massif_idx;
	}
	public void setMassif_idx(String massif_idx) {
		this.massif_idx = massif_idx;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 289138535371034721L;
	private  int idx;
	private Date admissibility_time;//受理时间
	private String construct_unit;//建设单位
	private String design_unit;//设计单位
	private String censorship;//审查机构
	private String approval_stage;//审批阶段
	private String relevant_archives;//审批相关档案
	private String massif_idx;//地块idx
	private String P;//url
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
}
