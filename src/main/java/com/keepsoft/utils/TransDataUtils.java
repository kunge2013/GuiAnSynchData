package com.keepsoft.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.keepsoft.domain.DESIGN_APPROVAL_FIRST;
import com.keepsoft.domain.DESIGN_APPROVAL_SECOND;
import com.keepsoft.domain.DESIGN_APPROVAL_THIRD;
import com.keepsoft.domain.DESIGN_MASSIF_FIRST;
import com.keepsoft.domain.DESIGN_MASSIF_SECOND;
import com.keepsoft.domain.DESIGN_MASSIF_THIRD;
import com.keepsoft.domain.V_HMFASC_OA;
import com.keepsoft.domain.V_HMGHTJ_OA;
import com.keepsoft.domain.V_HMSGTSC_OA;

/**
 * 数据转换器
 * @author admin
 *
 */
public class TransDataUtils {
	/**
	 * 规划条件 
	 * 道路
	 * @param list
	 * @return
	 */
	public static List<DESIGN_APPROVAL_FIRST> trans2AppFirsts(List<V_HMGHTJ_OA> list){
		List<DESIGN_APPROVAL_FIRST> appFirsts = new ArrayList<>();
		list.forEach(obj->
		{
			String name = obj.getCASENAME();//地块（道路）名称
			String road_pro_ID = obj.getCASEID();//道路 项目ID
			String details_condition = "年径流总量控制率:" + obj.getNJLZLKZL()+"SS去除率（%）:"+obj.getSSQCL()
			+"透水铺装率（%）:" + obj.getTSPZL() +"下沉式绿地率（%）:"+obj.getXCSLDL()
			+"绿色屋顶率（%）:" +obj.getLSWDL() +"单位面积调蓄容积（m3/ha):"+obj.getDWMJTXRJ();//规划设计条件
			
			DESIGN_APPROVAL_FIRST approval_FIRST = new DESIGN_APPROVAL_FIRST();
			approval_FIRST.setDetails_condition(details_condition);
			approval_FIRST.setName(name);
			approval_FIRST.setRoad_pro_ID(road_pro_ID);
			approval_FIRST.setP(obj.getP());
			appFirsts.add(approval_FIRST);
		});
		return appFirsts;
	}
	
	/**
	 * 规划条件 
	 * 项目
	 * @param list
	 * @return
	 */
	public static List<DESIGN_MASSIF_FIRST> trans2MassFirsts(List<V_HMGHTJ_OA> list){
		List<DESIGN_MASSIF_FIRST> appFirsts = new ArrayList<>();
		list.forEach(obj->
		{
			String name = obj.getCASENAME();//地块（道路）名称
			String road_pro_ID = obj.getCASEID();//道路 项目ID
			String details_condition = "年径流总量控制率:" + obj.getNJLZLKZL()+"SS去除率（%）:"+obj.getSSQCL()
			+"透水铺装率（%）:" + obj.getTSPZL() +"下沉式绿地率（%）:"+obj.getXCSLDL()
			+"绿色屋顶率（%）:" +obj.getLSWDL() +"单位面积调蓄容积（m3/ha):"+obj.getDWMJTXRJ();//规划设计条件
			
			DESIGN_MASSIF_FIRST approval_FIRST = new DESIGN_MASSIF_FIRST();
			approval_FIRST.setDetails_condition(details_condition);
			approval_FIRST.setName(name);
			approval_FIRST.setMassif_idx(road_pro_ID);
			approval_FIRST.setP(obj.getP());
			appFirsts.add(approval_FIRST);
		});
		return appFirsts;
	}
	/**
	 * 审查方案
	 * 道路
	 * @param list
	 * @return
	 */
	public static List<DESIGN_APPROVAL_SECOND> trans2AppSeconds(List<V_HMFASC_OA> list){
		List<DESIGN_APPROVAL_SECOND> appSeconds = new ArrayList<>();
		list.forEach(obj->{
			Date admissibility_time = obj.getSENDDATE();//受理时间
			String construct_unit =obj.getUNITNAME();//建设单位
			String design_unit =obj.getSJDWMC();//设计单位
			String censorship = "";//审查机构
			String approval_stage =obj.getACTNAME();//审批阶段
			String relevant_archives = "";//审批相关档案
			String road_pro_ID = "";//道路idx
			String p =obj.getP();
			DESIGN_APPROVAL_SECOND approval_SECOND = new DESIGN_APPROVAL_SECOND();
			approval_SECOND.setAdmissibility_time(admissibility_time);//
			approval_SECOND.setConstruct_unit(construct_unit);
			approval_SECOND.setDesign_unit(design_unit);
			approval_SECOND.setCensorship(censorship);
			approval_SECOND.setApproval_stage(approval_stage);
			approval_SECOND.setRelevant_archives(relevant_archives);
			approval_SECOND.setRoad_pro_ID(road_pro_ID);
			approval_SECOND.setP(p);
			appSeconds.add(approval_SECOND);
		});
		return appSeconds;
	}
	

	/**
	 * 审查方案
	 * 项目
	 * @param list
	 * @return
	 */
	public static List<DESIGN_MASSIF_SECOND> trans2MassSeconds(List<V_HMFASC_OA> list){
		List<DESIGN_MASSIF_SECOND> appSeconds = new ArrayList<>();
		
		list.forEach(obj->{
			Date admissibility_time = obj.getSENDDATE();//受理时间
			String construct_unit =obj.getUNITNAME();//建设单位
			String design_unit =obj.getSJDWMC();//设计单位
			String censorship = "";//审查机构
			String approval_stage =obj.getACTNAME();//审批阶段
			String relevant_archives = "";//审批相关档案
			String massif_idx = "";//道路idx
			String p =obj.getP();
			DESIGN_MASSIF_SECOND approval_SECOND = new DESIGN_MASSIF_SECOND();
			approval_SECOND.setAdmissibility_time(admissibility_time);//
			approval_SECOND.setConstruct_unit(construct_unit);
			approval_SECOND.setDesign_unit(design_unit);
			approval_SECOND.setCensorship(censorship);
			approval_SECOND.setApproval_stage(approval_stage);
			approval_SECOND.setRelevant_archives(relevant_archives);
			approval_SECOND.setMassif_idx(massif_idx);
			approval_SECOND.setP(p);
			appSeconds.add(approval_SECOND);
		});
		return appSeconds;
	}
	
	
	/**
	 * 施工图
	 * 道路
	 * @param list
	 * @return
	 */
	public static List<DESIGN_APPROVAL_THIRD> trans2AppThirds(List<V_HMSGTSC_OA> list){
		List<DESIGN_APPROVAL_THIRD> appThirds = new ArrayList<>();
		list.forEach(obj->{
			 DESIGN_APPROVAL_THIRD approval_THIRD = new DESIGN_APPROVAL_THIRD();
			 String construct_name = obj.getCASENAME();//建设名称
			 String construct_unit = obj.getUNITNAME();//建设单位
			 String design_unit = obj.getSJDWMC();//设计单位
			 String draw_organize = "";//审图机构
			 String approval_stage = obj.getACTNAME();//审批阶段
			 String relevant_archives = "";//审批相关档案
			 String road_pro_ID = obj.getCASENUM();//道路idx
			 String p = obj.getP();//url
			 approval_THIRD.setConstruct_name(construct_name);
			 approval_THIRD.setConstruct_unit(construct_unit);
			 approval_THIRD.setDesign_unit(design_unit);
			 approval_THIRD.setDraw_organize(draw_organize);
			 approval_THIRD.setApproval_stage(approval_stage);
			 approval_THIRD.setRelevant_archives(relevant_archives);
			 approval_THIRD.setRoad_pro_ID(road_pro_ID);
			 approval_THIRD.setP(p);
			 appThirds.add(approval_THIRD);
			 
		});
		
		return appThirds;
	}

	
	
	/**
	 * 施工图
	 * 项目
	 * @param list
	 * @return
	 */
	public static List<DESIGN_MASSIF_THIRD> trans2MassThirds(List<V_HMSGTSC_OA> list){
		List<DESIGN_MASSIF_THIRD> appThirds = new ArrayList<>();
		list.forEach(obj->{
			DESIGN_MASSIF_THIRD approval_THIRD = new DESIGN_MASSIF_THIRD();
			 String construct_name = obj.getCASENAME();//建设名称
			 String construct_unit = obj.getUNITNAME();//建设单位
			 String design_unit = obj.getSJDWMC();//设计单位
			 String draw_organize = "";//审图机构
			 String approval_stage = obj.getACTNAME();//审批阶段
			 String relevant_archives = "";//审批相关档案
			 String massif_idx = obj.getCASENUM();//道路idx
			 String p = obj.getP();//url
			 approval_THIRD.setConstruct_name(construct_name);
			 approval_THIRD.setConstruct_unit(construct_unit);
			 approval_THIRD.setDesign_unit(design_unit);
			 approval_THIRD.setDraw_organize(draw_organize);
			 approval_THIRD.setApproval_stage(approval_stage);
			 approval_THIRD.setRelevant_archives(relevant_archives);
			 approval_THIRD.setMassif_idx(massif_idx);
			 approval_THIRD.setP(p);
			 appThirds.add(approval_THIRD);
		});
		
		return appThirds;
	}
	
	
	
}
