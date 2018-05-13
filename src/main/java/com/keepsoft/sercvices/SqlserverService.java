package com.keepsoft.sercvices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepsoft.domain.EHR_USER;
import com.keepsoft.sqlserverdao.DataInsertMapper;

@Service
public class SqlserverService {

	@Autowired
	private DataInsertMapper mapper;
	
	public List<EHR_USER> queryData(){
		return mapper.findAll();
	}
}
