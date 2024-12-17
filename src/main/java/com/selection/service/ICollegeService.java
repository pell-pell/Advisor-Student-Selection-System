package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.College;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface ICollegeService extends IService<College> {


    IPage getPageList(QPage qPage, College obj);


    Result insertDb(College obj);


    College getByIds(Integer id);


    Result updatesDb(College obj);


    Result deleteDb(Integer id);


}
