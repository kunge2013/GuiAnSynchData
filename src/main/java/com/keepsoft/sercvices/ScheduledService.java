package com.keepsoft.sercvices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keepsoft.current.DealWithData;
import com.keepsoft.domain.T_PROJECT_MAPPER;
import com.keepsoft.domain.V_HMFASC_OA;
import com.keepsoft.domain.V_HMGHTJ_OA;
import com.keepsoft.domain.V_HMSGTSC_OA;
import com.keepsoft.utils.SpringIOC;
/**
 * 数据同步线程
 * @author fk
 */
@Service
public class ScheduledService {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledService.class);
    ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 诚心所 本地项目编号映射关系
     */
    private static Map<String, String> projectMapperMap = new ConcurrentHashMap<>();
    /**
     * 初始化当前的项目映射信息
     * @param map
     */
    
    public static void  initProjectMapperMap(Map<String, String> map){
    	projectMapperMap.clear();
    	projectMapperMap.putAll(map);
    }
    //定时一天更新一次
    @Scheduled( fixedRate = 1000*60*60*24)  
    public void initData() throws JsonProcessingException{
    	ProjectMapService service =  SpringIOC.getApplicationContext().getBean(ProjectMapService.class);
    	List<T_PROJECT_MAPPER> list = service.findAll();
    	Map<String, String> map = list.stream().collect(Collectors.toMap(T_PROJECT_MAPPER::getCxsPId, T_PROJECT_MAPPER::getLocalPId));
    	initProjectMapperMap(map);
    	log.info("初始化完成:" + objectMapper.writeValueAsString(list));
    } 
  
	/**
	 * 方案审查信息同步
	 */
	@Scheduled(cron = "${schedule.HMFASC}")
    public void scheduledHMFASC() throws JsonProcessingException
	{
		
       QueryHandlerService service = SpringIOC.getApplicationContext().getBean(QueryHandlerService.class);
       List<V_HMFASC_OA> list = service.findAllHMFASC(new HashMap<>());
	   log.info("方案审查信息 同步信息:" + objectMapper.writeValueAsString(list));
	   
	   list.forEach(obj->{
		   String itemNum =  obj.getITEMNUM();
		   obj.setITEMNUM(projectMapperMap.get(itemNum) == null?itemNum:itemNum);
	   });
	   
	   DealWithData.doSaveSecond(list);
	}
	/**
	 * 规划条件海绵办节点信息
	 */
	@Scheduled(cron = "${schedule.HMGHTJ}")
    public void scheduledHMGHTJ() throws JsonProcessingException
	{
       QueryHandlerService service = SpringIOC.getApplicationContext().getBean(QueryHandlerService.class);
       List<V_HMGHTJ_OA> list = service.findAllHMGHTJ(new HashMap<>());
	   log.info("规划条件海绵办节点信息:" + objectMapper.writeValueAsString(list));
	   list.forEach(obj->{
		   String itemNum =  obj.getITEMNUM();
		   obj.setITEMNUM(projectMapperMap.get(itemNum) == null?itemNum:itemNum);
	   });
	   
	   DealWithData.doSaveFirst(list);
    }
	
	/**
	 * 海绵城市施工图审查
	 */
	@Scheduled(cron = "${schedule.HMSGTSC}")
    public void scheduledHMSGTSC() throws JsonProcessingException
	{
       QueryHandlerService service = SpringIOC.getApplicationContext().getBean(QueryHandlerService.class);
       List<V_HMSGTSC_OA> list = service.findAllHMSGTSC(new HashMap<>());
	   log.info("海绵城市施工图审查:" + objectMapper.writeValueAsString(list));
	   
	   list.forEach(obj->{
		   String itemNum =  obj.getITEMNUM();
		   obj.setITEMNUM(projectMapperMap.get(itemNum) == null?itemNum:itemNum);
	   });
	   
	   //业务数据处理
	   DealWithData.doSaveThird(list);
    }

}
