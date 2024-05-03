package com.dao;

import com.entity.AnnouncementEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnnouncementView;

/**
 * Bulletin Dao interface
 *
 * @author 
 */
public interface AnnouncementDao extends BaseMapper<AnnouncementEntity> {

   List<AnnouncementView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
