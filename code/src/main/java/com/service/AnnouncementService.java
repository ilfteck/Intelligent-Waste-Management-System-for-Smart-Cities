package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnnouncementEntity;
import java.util.Map;

/**
 * AnnouncementService
 */
public interface AnnouncementService extends IService<AnnouncementEntity> {

    /**
    * @param params 
    * @return Query data with paging
    */
     PageUtils queryPage(Map<String, Object> params);

}
