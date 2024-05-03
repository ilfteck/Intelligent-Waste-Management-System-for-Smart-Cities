package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RecycleReserveEntity;
import java.util.Map;

/**
 * 垃圾出库申请 服务类
 */
public interface RecycleReserveService extends IService<RecycleReserveEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}