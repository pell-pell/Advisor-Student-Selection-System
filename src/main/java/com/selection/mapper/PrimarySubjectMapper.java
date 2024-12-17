package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.College;
import com.selection.entity.PrimarySubject;
import com.selection.entity.view.PrimarySubjectView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrimarySubjectMapper extends BaseMapper<PrimarySubject> {


    List<PrimarySubjectView> getPageList(@Param("iPage") IPage iPage, @Param("obj") PrimarySubject obj);


    int insertDb(@Param("obj") PrimarySubject obj);


    PrimarySubject getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") PrimarySubject obj);


    int deleteDb(@Param("id") Integer id);


}
