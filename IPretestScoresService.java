package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.PretestScores;
import com.selection.entity.PrimarySubject;
import com.selection.entity.view.PretestScoresView;
import com.selection.entity.view.RetestScoresView;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IPretestScoresService extends IService<PretestScores> {


    IPage getPageList(QPage qPage, PretestScoresView obj);


    Result insertDb(PretestScores obj);


    PretestScores getByIds(Integer id);


    Result updatesDb(PretestScores obj);


    Result deleteDb(Integer id);


}
