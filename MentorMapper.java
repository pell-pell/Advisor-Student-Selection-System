package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.College;
import com.selection.entity.Mentor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MentorMapper extends BaseMapper<Mentor> {


    List<Mentor> getPageList(@Param("iPage") IPage iPage, @Param("obj") Mentor obj);


    int insertDb(@Param("obj") Mentor obj);


    Mentor getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") Mentor obj);


    int deleteDb(@Param("id") Integer id);


}
