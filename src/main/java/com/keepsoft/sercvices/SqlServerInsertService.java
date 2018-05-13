package com.keepsoft.sercvices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepsoft.domain.DESIGN_APPROVAL_FIRST;
import com.keepsoft.domain.DESIGN_APPROVAL_SECOND;
import com.keepsoft.domain.DESIGN_APPROVAL_THIRD;
import com.keepsoft.domain.DESIGN_MASSIF_FIRST;
import com.keepsoft.domain.DESIGN_MASSIF_SECOND;
import com.keepsoft.domain.DESIGN_MASSIF_THIRD;
import com.keepsoft.sqlserverdao.DataInsertMapper;
/**
 * 本地业务数据同步处理
 * @author fk
 */
@Service
@Transactional
public class SqlServerInsertService {

	@Autowired
	private DataInsertMapper sqlServerMapper;

	public void batchSaveAppFirst(List<DESIGN_APPROVAL_FIRST> list) 
	{
		sqlServerMapper.deleteBatchAppFirst(list);
		sqlServerMapper.insertBatchAppFirst(list);
	}

	public void batchSaveAppSecond(List<DESIGN_APPROVAL_SECOND> list) 
	{
		sqlServerMapper.deleteBatchAppSecond(list);
		sqlServerMapper.insertBatchAppSecond(list);
	}

	public void batchSaveAppThrid(List<DESIGN_APPROVAL_THIRD> list) 
	{
		sqlServerMapper.deleteBatchAppThrid(list);
		sqlServerMapper.insertBatchAppThrid(list);
	}
	
	public void  batchSaveMassFirst(List<DESIGN_MASSIF_FIRST> list)
	{
		sqlServerMapper.deleteBatchMassFirst(list);
		sqlServerMapper.insertBatchMassFirst(list);
	}
	
	public void  batchSaveMassSecond(List<DESIGN_MASSIF_SECOND> list)
	{
		sqlServerMapper.deleteBatchMassSecond(list);
		sqlServerMapper.insertBatchMassSecond(list);
	}
	
	public void  batchSaveMassThrid(List<DESIGN_MASSIF_THIRD> list)
	{
		sqlServerMapper.deleteBatchMassThrid(list);
		sqlServerMapper.insertBatchMassThrid(list);
	}
}
