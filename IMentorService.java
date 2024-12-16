package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.College;
import com.selection.entity.Mentor;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IMentorService extends IService<Mentor> {


    IPage getPageList(QPage qPage, Mentor obj);


    Result insertDb(Mentor obj);


    Mentor getByIds(Integer id);


    Result updatesDb(Mentor obj);


    Result deleteDb(Integer id);


    Mentor login(String userAccount, String userPwd);



}
