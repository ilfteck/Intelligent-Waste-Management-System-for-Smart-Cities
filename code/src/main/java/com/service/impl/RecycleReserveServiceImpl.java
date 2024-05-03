package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import com.dao.MemberReserveDao;
import com.entity.RecycleReserveEntity;
import com.service.RecycleReserveService;
import com.entity.view.RecycleReserveView;

/**
 * 垃圾出库申请 服务实现类
 */
@Service("RecycleReserveService")
@Transactional
public class RecycleReserveServiceImpl extends ServiceImpl<MemberReserveDao, RecycleReserveEntity> implements
    RecycleReserveService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<RecycleReserveView> page =new Query<RecycleReserveView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
