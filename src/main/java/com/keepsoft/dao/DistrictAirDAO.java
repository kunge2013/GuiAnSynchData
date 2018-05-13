package com.keepsoft.dao;

import com.keepsoft.domain.DistrictAir;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 10195 on 2017/7/16.
 */
public interface DistrictAirDAO {
	
    @Select("select * from district")
    List<DistrictAir> findAllDistrict();
    List<DistrictAir> findCurrentPageData(Map pageKit);
    int findCountPage(Map pageKit);
}
