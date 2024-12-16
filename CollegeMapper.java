package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.College;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegeMapper extends BaseMapper<College> {


    List<College> getPageList(@Param("iPage") IPage iPage, @Param("obj") College obj);


    int insertDb(@Param("obj") College obj);


    College getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") College obj);


    int deleteDb(@Param("id") Integer id);


}
