package com.keepsoft.sercvices;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepsoft.dao.QueryDataMapper;
import com.keepsoft.domain.V_HMFASC_OA;
import com.keepsoft.domain.V_HMGHTJ_OA;
import com.keepsoft.domain.V_HMSGTSC_OA;

@Service
public class QueryHandlerService {
	@Autowired
	private QueryDataMapper queryDataMapper;
	
	/**
	 * 海绵城市方案审查信息
	 * @return
	 */
	public List<V_HMFASC_OA> findAllHMFASC(Map  map){
		
		return queryDataMapper.findAllHMFASC(map);
	}
	/**
	 * 规划条件海绵办节点信息
	 * @return
	 */
	public List<V_HMGHTJ_OA> findAllHMGHTJ(Map  map){
		return queryDataMapper.findAllHMGHTJ(map);
	}
	
	/**
	 * 海绵城市施工图审查
	 * @return
	 */
	public List<V_HMSGTSC_OA> findAllHMSGTSC(Map map){
		return queryDataMapper.findAllHMSGTSC(map);
	}
}
