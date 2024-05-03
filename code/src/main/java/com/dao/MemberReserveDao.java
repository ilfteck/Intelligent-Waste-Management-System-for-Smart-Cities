package com.dao;

import com.entity.RecycleReserveEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RecycleReserveView;

/**
 * Apply Dao interface for garbage outlet
 *
 * @author 
 */
public interface MemberReserveDao extends BaseMapper<RecycleReserveEntity> {

   List<RecycleReserveView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
