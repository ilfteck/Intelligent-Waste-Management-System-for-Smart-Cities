package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MemberEntity;
import java.util.Map;

/**
 * MemberService
 */
public interface MemberService extends IService<MemberEntity> {

    /**
    * @param params 
    * @return 
    */
     PageUtils queryPage(Map<String, Object> params);

}
