package com.dao;

import com.entity.MemberEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MemberView;

/**
 * User Dao interface
 *
 * @author 
 */
public interface MemberDao extends BaseMapper<MemberEntity> {

   List<MemberView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
