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

    //分页查询
    //根据考生ID和导师ID进行条件查询。
    //返回一个List<MentorChoiceConfirmationView>对象
    List<MentorChoiceConfirmationView> getPageList(@Param("iPage") IPage iPage, @Param("obj") MentorChoiceConfirmationView obj);

    //将新的导师选择确认信息插入到mentor_choice_confirmation表
    int insertDb(@Param("obj") MentorChoiceConfirmation obj);

    //查询mentor_choice_confirmation表中对应ID的记录
    MentorChoiceConfirmation getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") MentorChoiceConfirmation obj);


    int deleteDb(@Param("id") Integer id);


}
