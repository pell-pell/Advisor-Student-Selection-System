package com.selection.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.PretestScores;
import com.selection.entity.RetestScores;
import com.selection.entity.view.PretestScoresView;
import com.selection.entity.view.RetestScoresView;
import com.selection.mapper.PretestScoresMapper;
import com.selection.mapper.RetestScoresMapper;
import com.selection.qpage.QPage;
import com.selection.service.IPretestScoresService;
import com.selection.service.IRetestScoresService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetestScoresServiceImpl extends ServiceImpl<RetestScoresMapper, RetestScores> implements IRetestScoresService {


    @Override
    public IPage getPageList(QPage qPage, RetestScoresView obj) {
        IPage iPage = new Page(qPage.getPage(), qPage.getRows());
        List<RetestScoresView> mapList = this.baseMapper.getPageList(iPage,obj);
        return iPage.setRecords(mapList);
    }

    @Override
    public Result insertDb(RetestScores obj) {
        int count=this.baseMapper.insertDb(obj);
        if(count==1){
            return Result.reOk("新增成功");
        }
        return Result.reError("新增失败");
    }

    @Override
    public RetestScores getByIds(Integer id) {
        return this.baseMapper.getByIds(id);
    }

    @Override
    public Result updatesDb(RetestScores obj) {
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
