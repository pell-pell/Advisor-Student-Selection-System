package com.selection.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.PrimarySubject;
import com.selection.entity.SecondarySubject;
import com.selection.entity.view.PrimarySubjectView;
import com.selection.entity.view.SecondarySubjectView;
import com.selection.mapper.PrimarySubjectMapper;
import com.selection.mapper.SecondarySubjectMapper;
import com.selection.qpage.QPage;
import com.selection.service.IPrimarySubjectService;
import com.selection.service.ISecondarySubjectService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondarySubjectServiceImpl extends ServiceImpl<SecondarySubjectMapper, SecondarySubject> implements ISecondarySubjectService {


    @Override
    public IPage getPageList(QPage qPage, SecondarySubject obj) {
        IPage iPage = new Page(qPage.getPage(), qPage.getRows());
        List<SecondarySubjectView> mapList = this.baseMapper.getPageList(iPage,obj);
        return iPage.setRecords(mapList);
    }

    @Override
    public Result insertDb(SecondarySubject obj) {
        int count=this.baseMapper.insertDb(obj);
        if(count==1){
            return Result.reOk("新增成功");
        }
        return Result.reError("新增失败");
    }

    @Override
    public SecondarySubject getByIds(Integer id) {
        return this.baseMapper.getByIds(id);
    }

    @Override
    public Result updatesDb(SecondarySubject obj) {
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
