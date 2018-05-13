package com.keepsoft.domain;

import java.io.Serializable;

/**
 * 地块
 * 海绵城市规划设计条件详情
 * @author admin
 *
 */
public class DESIGN_MASSIF_FIRST implements Serializable {

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
	public int getIs_feed_back() {
		return is_feed_back;
	}
	public void setIs_feed_back(int is_feed_back) {
		this.is_feed_back = is_feed_back;
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
	private static final long serialVersionUID = 1615486380684601893L;
	private int idx;
	private String name;//地块（道路）名称
	private String details_condition;//海绵城市规划设计条件详情
	private int is_feed_back;//是否反馈市政科（0：反馈，1：不反馈）
	private String massif_idx;//地块idx
	private String P;//url
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
}
