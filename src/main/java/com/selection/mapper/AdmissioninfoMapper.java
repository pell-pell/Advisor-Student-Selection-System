package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.Admissioninfo;
import com.selection.entity.PretestScores;
import com.selection.entity.view.AdmissioninfoView;
import com.selection.entity.view.PretestScoresView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdmissioninfoMapper extends BaseMapper<Admissioninfo> {


    List<AdmissioninfoView> getPageList(@Param("iPage") IPage iPage, @Param("obj") AdmissioninfoView obj);


    int insertDb(@Param("obj") Admissioninfo obj);


    Admissioninfo getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") Admissioninfo obj);


    int deleteDb(@Param("id") Integer id);


}
