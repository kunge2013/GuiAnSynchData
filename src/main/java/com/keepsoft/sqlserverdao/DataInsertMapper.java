package com.keepsoft.sqlserverdao;

import java.util.List;

import com.keepsoft.domain.DESIGN_APPROVAL_FIRST;
import com.keepsoft.domain.DESIGN_APPROVAL_SECOND;
import com.keepsoft.domain.DESIGN_APPROVAL_THIRD;
import com.keepsoft.domain.DESIGN_MASSIF_FIRST;
import com.keepsoft.domain.DESIGN_MASSIF_SECOND;
import com.keepsoft.domain.DESIGN_MASSIF_THIRD;
import com.keepsoft.domain.EHR_USER;

/**
 * 批量插入
 * @author admin
 *
 */
public interface DataInsertMapper {
	
	List<EHR_USER> findAll();
	
	/***********************批量插入*****************************/
	void insertBatchAppFirst(List<DESIGN_APPROVAL_FIRST> list);
	
	void insertBatchAppSecond(List<DESIGN_APPROVAL_SECOND> list);
	
	void insertBatchAppThrid(List<DESIGN_APPROVAL_THIRD> list);
	
	void insertBatchMassFirst(List<DESIGN_MASSIF_FIRST> list);
//	
	void insertBatchMassSecond(List<DESIGN_MASSIF_SECOND> list);
//	
	void insertBatchMassThrid(List<DESIGN_MASSIF_THIRD> list);
	
	/***********************批量删除*****************************/
	void deleteBatchAppFirst(List<DESIGN_APPROVAL_FIRST> list);
	
	void deleteBatchAppSecond(List<DESIGN_APPROVAL_SECOND> list);
	
	void deleteBatchAppThrid(List<DESIGN_APPROVAL_THIRD> list);
	
	void deleteBatchMassFirst(List<DESIGN_MASSIF_FIRST> list);
//	
	void deleteBatchMassSecond(List<DESIGN_MASSIF_SECOND> list);
//	
	void deleteBatchMassThrid(List<DESIGN_MASSIF_THIRD> list);
	
}
