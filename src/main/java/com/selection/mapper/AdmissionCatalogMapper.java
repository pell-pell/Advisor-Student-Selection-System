package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.AdmissionCatalog;
import com.selection.entity.PrimarySubject;
import com.selection.entity.view.AdmissionCatalogView;
import com.selection.entity.view.PrimarySubjectView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdmissionCatalogMapper extends BaseMapper<AdmissionCatalog> {


    List<AdmissionCatalogView> getPageList(@Param("iPage") IPage iPage, @Param("obj") AdmissionCatalog obj);


    int insertDb(@Param("obj") AdmissionCatalog obj);


    AdmissionCatalog getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") AdmissionCatalog obj);


    int deleteDb(@Param("id") Integer id);


}
