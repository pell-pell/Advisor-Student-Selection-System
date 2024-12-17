package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.PretestScores;
import com.selection.entity.RetestScores;
import com.selection.entity.view.PretestScoresView;
import com.selection.entity.view.RetestScoresView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RetestScoresMapper extends BaseMapper<RetestScores> {


    List<RetestScoresView> getPageList(@Param("iPage") IPage iPage, @Param("obj") RetestScoresView obj);


    int insertDb(@Param("obj") RetestScores obj);


    RetestScores getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") RetestScores obj);


    int deleteDb(@Param("id") Integer id);


}
