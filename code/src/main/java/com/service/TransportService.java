package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TransportEntity;
import java.util.Map;

/**
 * TransportService
 */
public interface TransportService extends IService<TransportEntity> {

    /**
    * @param params 
    * @return 
    */
     PageUtils queryPage(Map<String, Object> params);

}
