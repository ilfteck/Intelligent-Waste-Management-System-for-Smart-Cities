package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import com.dao.TransportDao;
import com.entity.TransportEntity;
import com.service.TransportService;
import com.entity.view.TransportView;

/**
 * TransportService
 */
@Service("TransportService")
@Transactional
public class TransportServiceImpl extends ServiceImpl<TransportDao, TransportEntity> implements TransportService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<TransportView> page =new Query<TransportView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
