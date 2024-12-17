package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.PretestScores;
import com.selection.entity.PrimarySubject;
import com.selection.entity.view.PretestScoresView;
import com.selection.entity.view.PrimarySubjectView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PretestScoresMapper extends BaseMapper<PretestScores> {


    List<PretestScoresView> getPageList(@Param("iPage") IPage iPage, @Param("obj") PretestScoresView obj);


    int insertDb(@Param("obj") PretestScores obj);


    PretestScores getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") PretestScores obj);


    int deleteDb(@Param("id") Integer id);


}
