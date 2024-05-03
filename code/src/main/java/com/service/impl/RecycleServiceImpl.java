package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import com.dao.RecycleDao;
import com.entity.RecycleEntity;
import com.service.RecycleService;
import com.entity.view.RecycleView;

/**
 * 垃圾回收 服务实现类
 */
@Service("RecycleService")
@Transactional
public class RecycleServiceImpl extends ServiceImpl<RecycleDao, RecycleEntity> implements RecycleService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<RecycleView> page =new Query<RecycleView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
