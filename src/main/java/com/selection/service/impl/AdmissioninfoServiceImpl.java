package com.selection.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.Admissioninfo;
import com.selection.entity.PretestScores;
import com.selection.entity.view.AdmissioninfoView;
import com.selection.entity.view.PretestScoresView;
import com.selection.mapper.AdmissioninfoMapper;
import com.selection.mapper.PretestScoresMapper;
import com.selection.qpage.QPage;
import com.selection.service.IAdmissioninfoService;
import com.selection.service.IPretestScoresService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissioninfoServiceImpl extends ServiceImpl<AdmissioninfoMapper, Admissioninfo> implements IAdmissioninfoService {


    @Override
    public IPage getPageList(QPage qPage, AdmissioninfoView obj) {
        IPage iPage = new Page(qPage.getPage(), qPage.getRows());
        List<AdmissioninfoView> mapList = this.baseMapper.getPageList(iPage,obj);
        return iPage.setRecords(mapList);
    }

    @Override
    public Result insertDb(Admissioninfo obj) {
        int count=this.baseMapper.insertDb(obj);
        if(count==1){
            return Result.reOk("新增成功");
        }
        return Result.reError("新增失败");
    }

    @Override
    public Admissioninfo getByIds(Integer id) {
        return this.baseMapper.getByIds(id);
    }

    @Override
    public Result updatesDb(Admissioninfo obj) {
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
