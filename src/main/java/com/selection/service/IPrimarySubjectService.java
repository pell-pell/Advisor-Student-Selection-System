package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.College;
import com.selection.entity.PrimarySubject;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IPrimarySubjectService extends IService<PrimarySubject> {


    IPage getPageList(QPage qPage, PrimarySubject obj);


    Result insertDb(PrimarySubject obj);


    PrimarySubject getByIds(Integer id);


    Result updatesDb(PrimarySubject obj);


    Result deleteDb(Integer id);


}
