package com.keepsoft.sercvices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keepsoft.current.DealWithData;
import com.keepsoft.domain.EHR_USER;
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
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * 方案审查信息同步
	 */
	@Scheduled(cron = "${schedule.HMFASC}")
    public void scheduledHMFASC() throws JsonProcessingException
	{
       QueryHandlerService service = SpringIOC.getApplicationContext().getBean(QueryHandlerService.class);
       List<V_HMFASC_OA> list = service.findAllHMFASC(new HashMap<>());
	   log.info("时间: {}", dateFormat.format(new Date()) +"=====>>>>>方案审查信息 同步信息"+"数据:" + objectMapper.writeValueAsString(list));
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
	   log.info("时间: {}", dateFormat.format(new Date()) +"=====>>>>>规划条件海绵办节点信息 "+"数据:" + objectMapper.writeValueAsString(list));
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
	   log.info("时间: {}", dateFormat.format(new Date()) +"=====>>>>>海绵城市施工图审查 "+"数据:" + objectMapper.writeValueAsString(list));
	   //业务数据处理
	   DealWithData.doSaveThird(list);
    }

}
