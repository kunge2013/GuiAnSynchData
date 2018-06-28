package com.keepsoft.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keepsoft.domain.T_PROJECT_MAPPER;
import com.keepsoft.sercvices.ProjectMapService;
import com.keepsoft.sercvices.ScheduledService;

/**
 * 
 * @author admin
 *
 */
@Controller
@EnableAutoConfiguration
public class InitAction {
	ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ProjectMapService projectService;
    @InitBinder
    private void dateBind(ServletRequestDataBinder binder){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(df,true));
    }
  
    @RequestMapping("/infoView.do")
    public String infoView(HttpServletRequest request) throws JsonProcessingException{
        return "infoManage";
    }
    /**
     * 查询所有的映射关系
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping("/infoList.do")
    public String infoList() throws JsonProcessingException{
    	Map<String, Object> resultMap = new HashMap<>();
    	resultMap.put("infoData", projectService.findAll());
    	resultMap.put("localProjects", projectService.findAllProjects());
    	return objectMapper.writeValueAsString(resultMap);
    }
    
    
    @ResponseBody
    @RequestMapping("/saveInfo.do")
    public String saveInfo(T_PROJECT_MAPPER data,HttpServletRequest request) throws JsonProcessingException{
    	projectService.saveOrUpdate(data);
    	Map<String, Object> resultMap = new HashMap<>();
    	final List<T_PROJECT_MAPPER> list = projectService.findAll();
    	resultMap.put("infoData", list);
    	resultMap.put("data", data);
    	/**
    	 * 刷新缓存
    	 */
    	new Thread(new  Runnable() {
			public void run() {
				try {
					refreshProjectMapperMap(list);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
    	return objectMapper.writeValueAsString(resultMap);
    }
    
    @ResponseBody
    @RequestMapping("/removeInfo.do")
    public String removeInfo(T_PROJECT_MAPPER data) throws JsonProcessingException{
    	int i = projectService.remove(data);
    	Map<String, Object> resultMap = new HashMap<>();
    	List<T_PROJECT_MAPPER> list = projectService.findAll();
    	/**
    	 * 刷新缓存
    	 */
    	new Thread(new  Runnable() {
			public void run() {
				try {
					refreshProjectMapperMap(list);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
    	
    	resultMap.put("infoData", list);
    	resultMap.put("removeCount", i);
    	return objectMapper.writeValueAsString(resultMap);
    }
    private static final Logger log = LoggerFactory.getLogger(ScheduledService.class);
    
    /**
     * 刷新缓存
     * @param list
     * @throws JsonProcessingException
     */
     public void refreshProjectMapperMap(List<T_PROJECT_MAPPER> list) throws JsonProcessingException{
    	Map<String, String> map = list.stream().collect(Collectors.toMap(T_PROJECT_MAPPER::getCxsPId, T_PROJECT_MAPPER::getLocalPId));
    	ScheduledService.initProjectMapperMap(map);
    	log.info("初始化完成:" + objectMapper.writeValueAsString(list));
    }
}
