package com.keepsoft.dao;

import java.util.List;
import java.util.Map;

import com.keepsoft.domain.V_HMFASC_OA;
import com.keepsoft.domain.V_HMGHTJ_OA;
import com.keepsoft.domain.V_HMSGTSC_OA;


public interface QueryDataMapper {
	//查询所有的是施工图
	List<V_HMSGTSC_OA> findAllHMSGTSC(Map<String, Object> map);
	//查询所有海绵城市方案审查信息
	List<V_HMFASC_OA> findAllHMFASC(Map<String, Object> map);
	//查询所有规划条件海绵办节点信息V_HMGHTJ_OA
	List<V_HMGHTJ_OA> findAllHMGHTJ(Map<String, Object> map);
}
