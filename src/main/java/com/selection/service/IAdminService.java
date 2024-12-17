package com.selection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.selection.entity.Admin;
import com.selection.entity.Mentor;
import com.selection.qpage.QPage;
import com.selection.util.Result;


public interface IAdminService extends IService<Admin> {


    Admin login(String userAccount, String userPwd);


    void updatesDb(Admin admin);


}
