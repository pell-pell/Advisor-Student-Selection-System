package com.selection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.ApplicationPreferences;
import com.selection.entity.PretestScores;
import com.selection.entity.view.ApplicationPreferencesView;
import com.selection.entity.view.PretestScoresView;
import com.selection.mapper.ApplicationPreferencesMapper;
import com.selection.mapper.PretestScoresMapper;
import com.selection.qpage.QPage;
import com.selection.service.IApplicationPreferencesService;
import com.selection.service.IPretestScoresService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ApplicationPreferencesServiceImpl extends ServiceImpl<ApplicationPreferencesMapper, ApplicationPreferences> implements IApplicationPreferencesService {


    @Override
    public IPage getPageList(QPage qPage, ApplicationPreferencesView obj) {
        IPage iPage = new Page(qPage.getPage(), qPage.getRows());
        List<ApplicationPreferencesView> mapList = this.baseMapper.getPageList(iPage,obj);
        return iPage.setRecords(mapList);
    }

    @Override
    public Result insertDb(ApplicationPreferences obj) {
        //验证当前考生是否已经填报过了志愿，只允许填写依次
        QueryWrapper<ApplicationPreferences> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("candidate_id",obj.getCandidateId());
        List<ApplicationPreferences> applicationPreferencesList=this.list(queryWrapper);
        if(applicationPreferencesList!=null&&applicationPreferencesList.size()>=1){
            return Result.reError("一个考生只允许填写依次志愿");
        }
        int count=this.baseMapper.insertDb(obj);
        if(count==1){
            return Result.reOk("新增成功");
        }
        return Result.reError("新增失败");
    }

    @Override
    public ApplicationPreferences getByIds(Integer id) {
        return this.baseMapper.getByIds(id);
    }

    @Override
    public Result updatesDb(ApplicationPreferences obj) {
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
    public List<ApplicationPreferences> getMentorById(Integer mentorId) {
        QueryWrapper<ApplicationPreferences> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("preferred_mentorone_id",mentorId).or().eq("preferred_mentortwo_id",mentorId)
                .or().eq("preferred_mentorthree_id",mentorId);
        return this.list(queryWrapper);
    }


}
