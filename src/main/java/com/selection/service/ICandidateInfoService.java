package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.CandidateInfo;
import com.selection.entity.Mentor;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface ICandidateInfoService extends IService<CandidateInfo> {


    IPage getPageList(QPage qPage, CandidateInfo obj);


    Result insertDb(CandidateInfo obj);


    CandidateInfo getByIds(Integer id);


    Result updatesDb(CandidateInfo obj);


    Result deleteDb(Integer id);


    CandidateInfo login(String userAccount, String userPwd);


}
