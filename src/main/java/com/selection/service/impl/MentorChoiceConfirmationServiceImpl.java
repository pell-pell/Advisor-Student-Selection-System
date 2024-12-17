package com.selection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.MentorChoiceConfirmation;
import com.selection.entity.PretestScores;
import com.selection.entity.view.MentorChoiceConfirmationView;
import com.selection.entity.view.PretestScoresView;
import com.selection.mapper.MentorChoiceConfirmationMapper;
import com.selection.mapper.PretestScoresMapper;
import com.selection.qpage.QPage;
import com.selection.service.IMentorChoiceConfirmationService;
import com.selection.service.IPretestScoresService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorChoiceConfirmationServiceImpl extends ServiceImpl<MentorChoiceConfirmationMapper, MentorChoiceConfirmation> implements IMentorChoiceConfirmationService {


    @Override
    public IPage getPageList(QPage qPage, MentorChoiceConfirmationView obj) {
        IPage iPage = new Page(qPage.getPage(), qPage.getRows());
        List<MentorChoiceConfirmationView> mapList = this.baseMapper.getPageList(iPage,obj);
        return iPage.setRecords(mapList);
    }

    @Override
    public Result insertDb(MentorChoiceConfirmation obj) {
        //验证当前导师是否已经确认过了学生
        QueryWrapper<MentorChoiceConfirmation> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("mentor_id",obj.getMentorId());
        queryWrapper.eq("candidate_id",obj.getCandidateId());
        List<MentorChoiceConfirmation> mentorChoiceConfirmationList=this.list(queryWrapper);
        if(mentorChoiceConfirmationList!=null&&mentorChoiceConfirmationList.size()>=1){
            return Result.reError("新增失败,同一个学生你不能重复确认");
        }
        int count=this.baseMapper.insertDb(obj);
        if(count==1){
            return Result.reOk("新增成功");
        }
        return Result.reError("新增失败");
    }

    @Override
    public MentorChoiceConfirmation getByIds(Integer id) {
        return this.baseMapper.getByIds(id);
    }

    @Override
    public Result updatesDb(MentorChoiceConfirmation obj) {
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


}
