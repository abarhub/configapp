package org.configapp.service;

import com.google.common.collect.Maps;
import org.configapp.rest.Rest1;
import org.configapp.dto.InitDTO;
import org.configapp.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

import java.util.*;

/**
 * Created by tulip_000 on 09/08/2016.
 */
@Service
public class ConfigApp {

    private static Logger logger = LoggerFactory.getLogger(ConfigApp.class);

    private static final String template = "%08d";
    private final AtomicLong counter = new AtomicLong(1);

    private Map<String,Map<String,String>> map= Maps.newConcurrentMap();

    public String createApp(InitDTO initDTO){
        logger.info("Create "+initDTO.getName());
        String id=newId();
        Map<String,String> map2=Maps.newConcurrentMap();
        map.put(id,map2);
        return id;
    }

    private String newId()
    {
        long id=counter.getAndIncrement();
        return String.format(template,id);
    }

    public void config(String idApp,ConfigDTO configDTO){
        logger.info("Config "+idApp+" : "+configDTO);
        if(map.containsKey(idApp))
        {
            Map<String,String> map2=map.get(idApp);
            if(configDTO.getAdd()!=null){
                for(ParameterConfig parameterConfig:configDTO.getAdd()){
                    map2.put(parameterConfig.getKey(),parameterConfig.getValue());
                }
            }
            if(configDTO.getRemove()!=null){
                for(String key:configDTO.getRemove()){
                    if(map2.containsKey(key)) {
                        map2.remove(key);
                    }
                }
            }
            logger.info("res "+idApp+" : "+map2);
        }
    }
}
