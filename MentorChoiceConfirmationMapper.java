package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.MentorChoiceConfirmation;
import com.selection.entity.PretestScores;
import com.selection.entity.view.MentorChoiceConfirmationView;
import com.selection.entity.view.PretestScoresView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MentorChoiceConfirmationMapper extends BaseMapper<MentorChoiceConfirmation> {


    List<MentorChoiceConfirmationView> getPageList(@Param("iPage") IPage iPage, @Param("obj") MentorChoiceConfirmationView obj);


    int insertDb(@Param("obj") MentorChoiceConfirmation obj);


    MentorChoiceConfirmation getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") MentorChoiceConfirmation obj);


    int deleteDb(@Param("id") Integer id);


}
