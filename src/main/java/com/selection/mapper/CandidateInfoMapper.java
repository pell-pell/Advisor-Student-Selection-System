package com.selection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selection.entity.CandidateInfo;
import com.selection.entity.Mentor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CandidateInfoMapper extends BaseMapper<CandidateInfo> {


    List<CandidateInfo> getPageList(@Param("iPage") IPage iPage, @Param("obj") CandidateInfo obj);


    int insertDb(@Param("obj") CandidateInfo obj);


    CandidateInfo getByIds(@Param("id") Integer id);


    int updatesDb(@Param("obj") CandidateInfo obj);


    int deleteDb(@Param("id") Integer id);


}
