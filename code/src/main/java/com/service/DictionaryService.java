package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DictionaryEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import java.util.List;

/**
 * DictionaryService
 */
public interface DictionaryService extends IService<DictionaryEntity> {

    /**
    * @param params 
    * @return 
    */
     PageUtils queryPage(Map<String, Object> params);
      /**
      * Dictionary table conversion
      * @param obj
      */
     void dictionaryConvert(Object obj, HttpServletRequest request);

}
