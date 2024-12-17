package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.ApplicationPreferences;
import com.selection.entity.PretestScores;
import com.selection.entity.view.ApplicationPreferencesView;
import com.selection.entity.view.PretestScoresView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationPreferencesMapper extends BaseMapper<ApplicationPreferences> {


    List<ApplicationPreferencesView> getPageList(@Param("iPage") IPage iPage, @Param("obj") ApplicationPreferencesView obj);


    int insertDb(@Param("obj") ApplicationPreferences obj);


    ApplicationPreferences getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") ApplicationPreferences obj);


    int deleteDb(@Param("id") Integer id);


}
