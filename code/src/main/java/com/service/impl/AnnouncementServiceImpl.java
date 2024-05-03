package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import com.dao.AnnouncementDao;
import com.entity.AnnouncementEntity;
import com.service.AnnouncementService;
import com.entity.view.AnnouncementView;

/**
 * Announcement service implementation class
 */
@Service("AnnouncementService")
@Transactional
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementDao, AnnouncementEntity> implements
    AnnouncementService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<AnnouncementView> page =new Query<AnnouncementView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
