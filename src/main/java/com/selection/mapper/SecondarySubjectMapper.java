package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.PrimarySubject;
import com.selection.entity.SecondarySubject;
import com.selection.entity.view.PrimarySubjectView;
import com.selection.entity.view.SecondarySubjectView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondarySubjectMapper extends BaseMapper<SecondarySubject> {


    List<SecondarySubjectView> getPageList(@Param("iPage") IPage iPage, @Param("obj") SecondarySubject obj);


    int insertDb(@Param("obj") SecondarySubject obj);


    SecondarySubject getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") SecondarySubject obj);


    int deleteDb(@Param("id") Integer id);


}
