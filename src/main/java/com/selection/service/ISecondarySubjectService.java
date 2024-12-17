package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.PrimarySubject;
import com.selection.entity.SecondarySubject;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface ISecondarySubjectService extends IService<SecondarySubject> {


    IPage getPageList(QPage qPage, SecondarySubject obj);


    Result insertDb(SecondarySubject obj);


    SecondarySubject getByIds(Integer id);


    Result updatesDb(SecondarySubject obj);


    Result deleteDb(Integer id);


}
