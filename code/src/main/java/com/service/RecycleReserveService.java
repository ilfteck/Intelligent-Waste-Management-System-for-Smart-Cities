package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RecycleReserveEntity;
import java.util.Map;

/**
 * RecycleReserveService
 */
public interface RecycleReserveService extends IService<RecycleReserveEntity> {

    /**
    * @param params 
    * @return 
    */
     PageUtils queryPage(Map<String, Object> params);

}
