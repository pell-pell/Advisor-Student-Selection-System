package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.Admissioninfo;
import com.selection.entity.PretestScores;
import com.selection.entity.view.AdmissioninfoView;
import com.selection.entity.view.PretestScoresView;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IAdmissioninfoService extends IService<Admissioninfo> {


    IPage getPageList(QPage qPage, AdmissioninfoView obj);


    Result insertDb(Admissioninfo obj);


    Admissioninfo getByIds(Integer id);


    Result updatesDb(Admissioninfo obj);


    Result deleteDb(Integer id);


}
