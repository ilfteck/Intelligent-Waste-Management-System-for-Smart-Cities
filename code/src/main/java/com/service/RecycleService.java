package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RecycleEntity;
import java.util.Map;

/**
 * RecycleService 
 */
public interface RecycleService extends IService<RecycleEntity> {

    /**
    * @param params 
    * @return 
    */
     PageUtils queryPage(Map<String, Object> params);

}
