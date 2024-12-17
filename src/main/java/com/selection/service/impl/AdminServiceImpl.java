package com.selection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selection.entity.Admin;
import com.selection.entity.Mentor;
import com.selection.mapper.AdminMapper;
import com.selection.mapper.MentorMapper;
import com.selection.qpage.QPage;
import com.selection.service.IAdminService;
import com.selection.service.IMentorService;
import com.selection.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {


    @Override
    public Admin login(String userAccount, String userPwd) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account",userAccount);
        queryWrapper.eq("pwd",userPwd);
        return this.getOne(queryWrapper);
    }

    @Override
    public void updatesDb(Admin admin) {
        this.updateById(admin);
    }


}
