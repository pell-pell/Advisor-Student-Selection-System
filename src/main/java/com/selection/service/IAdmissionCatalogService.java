package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.AdmissionCatalog;
import com.selection.entity.PrimarySubject;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IAdmissionCatalogService extends IService<AdmissionCatalog> {


    IPage getPageList(QPage qPage, AdmissionCatalog obj);


    Result insertDb(AdmissionCatalog obj);


    AdmissionCatalog getByIds(Integer id);


    Result updatesDb(AdmissionCatalog obj);


    Result deleteDb(Integer id);


}
