package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RecycleEntity;
import java.util.Map;

/**
 * 垃圾回收 服务类
 */
public interface RecycleService extends IService<RecycleEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}