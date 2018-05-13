package com.keepsoft.domain;

import java.io.Serializable;

/**
    * MOBILE	手机号
	*CASEID	业务系统ID
	*ACTID	节点ID
	*ACTNAME	节点名称
	*CASENAME	业务名称
	*CASENUM	业务编号
	*NJLZLKZL	年径流总量控制率（%）
	*SSQCL	SS去除率（%）
	*TSPZL	透水铺装率（%）
	*XCSLDL	下沉式绿地率（%）
	*LSWDL	绿色屋顶率（%）
	*DWMJTXRJ	单位面积调蓄容积（m3/ha)
	*HMCSBCSM	海绵城市指标补充说明
	*P	跳转URL
    * @author admin
    *规划条件海绵办节点信息：V_HMGHTJ_OA
    */
public class V_HMGHTJ_OA implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9010593736855616464L;
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getCASEID() {
		return CASEID;
	}
	public void setCASEID(String cASEID) {
		CASEID = cASEID;
	}
	public String getACTID() {
		return ACTID;
	}
	public void setACTID(String aCTID) {
		ACTID = aCTID;
	}
	public String getACTNAME() {
		return ACTNAME;
	}
	public void setACTNAME(String aCTNAME) {
		ACTNAME = aCTNAME;
	}
	public String getCASENAME() {
		return CASENAME;
	}
	public void setCASENAME(String cASENAME) {
		CASENAME = cASENAME;
	}
	public String getCASENUM() {
		return CASENUM;
	}
	public void setCASENUM(String cASENUM) {
		CASENUM = cASENUM;
	}
	public String getNJLZLKZL() {
		return NJLZLKZL;
	}
	public void setNJLZLKZL(String nJLZLKZL) {
		NJLZLKZL = nJLZLKZL;
	}
	public String getSSQCL() {
		return SSQCL;
	}
	public void setSSQCL(String sSQCL) {
		SSQCL = sSQCL;
	}
	public String getTSPZL() {
		return TSPZL;
	}
	public void setTSPZL(String tSPZL) {
		TSPZL = tSPZL;
	}
	public String getXCSLDL() {
		return XCSLDL;
	}
	public void setXCSLDL(String xCSLDL) {
		XCSLDL = xCSLDL;
	}
	public String getLSWDL() {
		return LSWDL;
	}
	public void setLSWDL(String lSWDL) {
		LSWDL = lSWDL;
	}
	public String getDWMJTXRJ() {
		return DWMJTXRJ;
	}
	public void setDWMJTXRJ(String dWMJTXRJ) {
		DWMJTXRJ = dWMJTXRJ;
	}
	public String getHMCSBCSM() {
		return HMCSBCSM;
	}
	public void setHMCSBCSM(String hMCSBCSM) {
		HMCSBCSM = hMCSBCSM;
	}
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
	private String MOBILE;//手机号
	private String  CASEID;//业务系统ID
	private String ACTID;//节点ID
	private String ACTNAME;//节点名称
	private String CASENAME;//业务名称
	private String CASENUM;//业务编号
	private String NJLZLKZL;//年径流总量控制率（%）
	private String SSQCL;//SS去除率（%）
	private String TSPZL;//透水铺装率（%）
	private String XCSLDL;//下沉式绿地率（%）
	private String LSWDL;//绿色屋顶率（%）
	private String DWMJTXRJ;//单位面积调蓄容积（m3/ha)
	private String HMCSBCSM;//海绵城市指标补充说明
	private String P;//跳转URL
	
	private int type;// 0道路 1 项目
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
