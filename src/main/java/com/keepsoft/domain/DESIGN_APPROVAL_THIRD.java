package com.keepsoft.domain;

import java.io.Serializable;

/**
 * 道路
 * 建设项目海绵城市专项设计施工图审查
 * @author admin
 *
 */
public class DESIGN_APPROVAL_THIRD implements Serializable{

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
	public String getRoad_pro_ID() {
		return road_pro_ID;
	}
	public void setRoad_pro_ID(String road_pro_ID) {
		this.road_pro_ID = road_pro_ID;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -4881434590401986148L;
	private int idx;
	private String construct_name;//建设名称
	private String construct_unit;//建设单位
	private String design_unit;//设计单位
	private String draw_organize;//审图机构
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
