package com.keepsoft.domain;

import java.io.Serializable;

/**
 * 道路
 * 海绵城市规划设计条件详情
 * @author admin
 *
 */
public class DESIGN_APPROVAL_FIRST implements Serializable{
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails_condition() {
		return details_condition;
	}
	public void setDetails_condition(String details_condition) {
		this.details_condition = details_condition;
	}
	public String getIs_feed_back() {
		return is_feed_back;
	}
	public void setIs_feed_back(String is_feed_back) {
		this.is_feed_back = is_feed_back;
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
	private static final long serialVersionUID = -1198276847317468956L;
	private int idx;
	private String name;//地块（道路）名称
	private String details_condition;//海绵城市规划设计条件详情
	private String is_feed_back = "-1";//是否反馈市政科（0：反馈，1：不反馈）
	private String road_pro_ID;//道路idx
	private String P;//url
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}

}
