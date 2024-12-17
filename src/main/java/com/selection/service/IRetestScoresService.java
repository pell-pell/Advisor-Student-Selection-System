package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.PretestScores;
import com.selection.entity.RetestScores;
import com.selection.entity.view.RetestScoresView;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IRetestScoresService extends IService<RetestScores> {


    IPage getPageList(QPage qPage, RetestScoresView obj);


    Result insertDb(RetestScores obj);


    RetestScores getByIds(Integer id);


    Result updatesDb(RetestScores obj);


    Result deleteDb(Integer id);


}
