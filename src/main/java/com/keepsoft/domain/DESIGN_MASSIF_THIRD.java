package com.keepsoft.domain;

import java.io.Serializable;

/**
 * 地块
 * 建设项目海绵城市专项设计施工图审查
 * @author admin
 *
 */
public class DESIGN_MASSIF_THIRD implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6057413689991634475L;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getConstruct_name() {
		return construct_name;
	}
	public void setConstruct_name(String construct_name) {
		this.construct_name = construct_name;
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
	public String getDraw_organize() {
		return draw_organize;
	}
	public void setDraw_organize(String draw_organize) {
		this.draw_organize = draw_organize;
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
	private int	idx;
	private String construct_name;
	private String construct_unit;
	private String design_unit;
	private String draw_organize;
	private String approval_stage;
	private String relevant_archives;
	private String massif_idx;
	private String P;//url
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
}
