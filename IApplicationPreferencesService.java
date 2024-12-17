package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.ApplicationPreferences;
import com.selection.entity.PretestScores;
import com.selection.entity.view.ApplicationPreferencesView;
import com.selection.entity.view.PretestScoresView;
import com.selection.qpage.QPage;
import com.selection.util.Result;

import java.util.List;


public interface IApplicationPreferencesService extends IService<ApplicationPreferences> {


    IPage getPageList(QPage qPage, ApplicationPreferencesView obj);


    Result insertDb(ApplicationPreferences obj);


    ApplicationPreferences getByIds(Integer id);


    Result updatesDb(ApplicationPreferences obj);


    Result deleteDb(Integer id);

    /**
     * 根据导师ID获取是否有学生属于这个倒是
     * @param mentorId
     * @return
     */
    List<ApplicationPreferences> getMentorById(Integer mentorId);


}
