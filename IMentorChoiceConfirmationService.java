package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.MentorChoiceConfirmation;
import com.selection.entity.PretestScores;
import com.selection.entity.view.MentorChoiceConfirmationView;
import com.selection.entity.view.PretestScoresView;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IMentorChoiceConfirmationService extends IService<MentorChoiceConfirmation> {


    IPage getPageList(QPage qPage, MentorChoiceConfirmationView obj);


    Result insertDb(MentorChoiceConfirmation obj);


    MentorChoiceConfirmation getByIds(Integer id);


    Result updatesDb(MentorChoiceConfirmation obj);


    Result deleteDb(Integer id);


}
