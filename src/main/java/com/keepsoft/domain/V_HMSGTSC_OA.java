package com.keepsoft.domain;

import java.io.Serializable;

/**
MOBILE	手机号	VARCHAR2	50	Y	
CASEID	业务系统ID	VARCHAR2	20	Y	
ACTID	节点ID	VARCHAR2	20	Y	
ACTNAME	节点名称	VARCHAR2	200	Y	
CASENAME	业务名称	VARCHAR2	200	Y	
CASENUM	业务编号	VARCHAR2	50	Y	
UNITNAME	建设单位名称	VARCHAR2	50	Y	
SJDWMC	设计单位名称	VARCHAR2	50	Y	
P	跳转URL	VARCHAR2	157	Y	
 * @author admin
 *海绵城市施工图审V_HMSGTSC_OA查
 */
public class V_HMSGTSC_OA implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8962480559758049878L;
	/**
	* 字段名称	字段描述	类型	长度	可否为空	默认值
	*	MOBILE	手机号	VARCHAR2	50	Y	
	*CASEID	业务系统ID	VARCHAR2	20	Y	
	*	ACTID	节点ID	VARCHAR2	20	Y	
	*	ACTNAME	节点名称	VARCHAR2	200	Y	
	*	CASENAME	业务名称	VARCHAR2	200	Y	
	*	CASENUM	业务编号	VARCHAR2	50	Y	
	*	UNITNAME	建设单位名称	VARCHAR2	50	Y	
	*	SJDWMC	设计单位名称	VARCHAR2	50	Y	
	*	P	跳转URL	VARCHAR2	157	Y	
	 */
	private String MOBILE;//手机号
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
	public String getUNITNAME() {
		return UNITNAME;
	}
	public void setUNITNAME(String uNITNAME) {
		UNITNAME = uNITNAME;
	}
	public String getSJDWMC() {
		return SJDWMC;
	}
	public void setSJDWMC(String sJDWMC) {
		SJDWMC = sJDWMC;
	}
	public String getP() {
		return P;
	}
	public void setP(String p) {
		P = p;
	}
	private String CASEID;//业务系统ID
	private String ACTID;//节点ID
	
	private String ACTNAME;//节点名称
	private String CASENAME;//业务名称
	private String CASENUM;//业务编号
	
	private String UNITNAME;//建设单位名称
	private String SJDWMC;//设计单位名称
	private String P;//跳转URL
	
	
	private int type;// 0道路 1 项目
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
