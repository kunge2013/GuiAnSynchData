package com.keepsoft.current;

import java.util.List;
import java.util.stream.Collectors;

import com.keepsoft.domain.DESIGN_APPROVAL_FIRST;
import com.keepsoft.domain.DESIGN_APPROVAL_SECOND;
import com.keepsoft.domain.DESIGN_APPROVAL_THIRD;
import com.keepsoft.domain.DESIGN_MASSIF_FIRST;
import com.keepsoft.domain.DESIGN_MASSIF_SECOND;
import com.keepsoft.domain.DESIGN_MASSIF_THIRD;
import com.keepsoft.domain.V_HMFASC_OA;
import com.keepsoft.domain.V_HMGHTJ_OA;
import com.keepsoft.domain.V_HMSGTSC_OA;
import com.keepsoft.sercvices.SqlServerInsertService;
import com.keepsoft.utils.SpringIOC;
import com.keepsoft.utils.TransDataUtils;

/**
 * 处理业务数据
 * @author fk
 *
 */
public class DealWithData {
	
	public static final int  DEALTYPE_DAOLU = 0;// 道路
	public static final int  DEALTYPE_DIKUAI = 1;//地块
	
	private static SqlServerInsertService insertService = SpringIOC.getApplicationContext().getBean(SqlServerInsertService.class);
	//规划条件
	public static  int doSaveSecond(List<V_HMFASC_OA> list){
		List<V_HMFASC_OA> roads = list.stream().filter(obj->DEALTYPE_DAOLU==obj.getType()).collect(Collectors.toList());
		List<V_HMFASC_OA> areas = list.stream().filter(obj->DEALTYPE_DIKUAI==obj.getType()).collect(Collectors.toList());
		/**
		 * {
			"type":0,
			"mobile":"18275048698",
			"caseid":"BM00000395",
			"actid":"A024",
			"actname":"海绵处经办人审查",
			"casename":"测试项目视图-HYR",
			"casenum":"GHTJ201805-001",
			"p":"http://222.85.149.71:8085/GAweb4/YWSP/#?bimId=BM00000395&key=3&actId=A024&nId=N000007&type=1",
			"njlzlkzl":"5",
			"ssqcl":"10",
			"tspzl":"5.5",
			"xcsldl":"10",
			"lswdl":"11",
			"dwmjtxrj":"2.5",
			"hmcsbcsm":"补充说明"
			}
		 */
		if(roads.size() > 0)
		{
			//将对象转化成本地数据库中的对象
			List<DESIGN_APPROVAL_SECOND> saveList= TransDataUtils.trans2AppSeconds(roads);
			insertService.batchSaveAppSecond(saveList);
		}
		
		if(areas.size() > 0)
		{
			
			List<DESIGN_MASSIF_SECOND>  saveList =TransDataUtils.trans2MassSeconds(areas);
			insertService.batchSaveMassSecond(saveList);
		}
		return 0;
	}
	
	public static int doSaveThird(List<V_HMSGTSC_OA> list){
		List<V_HMSGTSC_OA> roads = list.stream().filter(obj->DEALTYPE_DAOLU==obj.getType()).collect(Collectors.toList());
		List<V_HMSGTSC_OA> areas = list.stream().filter(obj->DEALTYPE_DIKUAI==obj.getType()).collect(Collectors.toList());
		/**
		 * {
		"type":0,
		"mobile":"13631429615",
		"caseid":"BM00000371",
		"actid":"A007",
		"actname":"科长审核",
		"casename":"测试项目视图-HYR",
		"casenum":"GHHM201804-002",
		"unitname":"测试单位-HYR",
		"sjdwmc":"111",
		"p":"http://222.85.149.71:8085/GAweb4/YWSP/#?bimId=BM00000371&key=9&actId=A007&nId=N000007&type=1"
		},
		 */
		if(roads.size() > 0){
			List<DESIGN_APPROVAL_THIRD> saveList = TransDataUtils.trans2AppThirds(roads);
			insertService.batchSaveAppThrid(saveList);
		}
		
		if(areas.size() > 0){
			List<DESIGN_MASSIF_THIRD> saveList = TransDataUtils.trans2MassThirds(areas);
			insertService.batchSaveMassThrid(saveList);
		}
		
		return 0;
	}
	
	public static int doSaveFirst(List<V_HMGHTJ_OA> list){
		List<V_HMGHTJ_OA> roads = list.stream().filter(obj->DEALTYPE_DAOLU==obj.getType()).collect(Collectors.toList());
		List<V_HMGHTJ_OA> areas = list.stream().filter(obj->DEALTYPE_DIKUAI==obj.getType()).collect(Collectors.toList());
		/**
		 * {
			"type":0,
			"mobile":null,
			"caseid":"BM00000401",
			"actid":"A005",
			"actname":"经办人审查",
			"casename":"1",
			"casenum":"GHHM201805-004",
			"unitname":"1",
			"sjdwmc":"1111",
			"p":"http://222.85.149.71:8085/GAweb4/YWSP/#?bimId=BM00000401&key=4&actId=A005&nId=N000007&type=1"
			}
		 */
		if(roads.size() > 0)
		{
			List<DESIGN_APPROVAL_FIRST> saveList = TransDataUtils.trans2AppFirsts(roads);
			insertService.batchSaveAppFirst(saveList);
		}
		
		if(areas.size() > 0)
		{
			List<DESIGN_MASSIF_FIRST> saveList = TransDataUtils.trans2MassFirsts(areas);
			insertService.batchSaveMassFirst(saveList);
		}
		return 0;
	}
	
}
