package com.selection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.Admin;
import com.selection.entity.CandidateInfo;
import com.selection.entity.Mentor;
import com.selection.mapper.CandidateInfoMapper;
import com.selection.mapper.MentorMapper;
import com.selection.qpage.QPage;
import com.selection.service.ICandidateInfoService;
import com.selection.service.IMentorService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateInfoServiceImpl extends ServiceImpl<CandidateInfoMapper, CandidateInfo> implements ICandidateInfoService {


    @Override
    public IPage getPageList(QPage qPage, CandidateInfo obj) {
        IPage iPage = new Page(qPage.getPage(), qPage.getRows());
        List<CandidateInfo> mapList = this.baseMapper.getPageList(iPage,obj);
        return iPage.setRecords(mapList);
    }

    @Override
    public Result insertDb(CandidateInfo obj) {
        int count=this.baseMapper.insertDb(obj);
        if(count==1){
            return Result.reOk("新增成功");
        }
        return Result.reError("新增失败");
    }

    @Override
    public CandidateInfo getByIds(Integer id) {
        return this.baseMapper.getByIds(id);
    }

    @Override
    public Result updatesDb(CandidateInfo obj) {
        int count=this.baseMapper.updatesDb(obj);
        if(count==1){
            return Result.reOk("修改成功");
        }
        return Result.reError("修改失败");
    }

    @Override
    public Result deleteDb(Integer id) {
        int count=this.baseMapper.deleteDb(id);
        if(count==1){
            return Result.reOk("删除成功");
        }
        return Result.reError("删除失败");
    }

    @Override
    public CandidateInfo login(String userAccount, String userPwd) {
        QueryWrapper<CandidateInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",userAccount);
        queryWrapper.eq("pwd",userPwd);
        return this.getOne(queryWrapper);
    }


}