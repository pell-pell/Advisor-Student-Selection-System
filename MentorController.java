package com.selection.controller;
import com.selection.entity.ApplicationPreferences;
import com.selection.entity.College;
import com.selection.entity.Mentor;
import com.selection.qpage.QPage;
import com.selection.service.ICollegeService;
import com.selection.service.IMentorService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin/mentor")
public class MentorController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/mentor";

    /**
     * 业务层
     */
    @Autowired
    private IMentorService service;


    /**
     * 进入管理页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return prefix+"/index";
    }


    /**
     * 获取所有的列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result getList(QPage qPage, Mentor obj, HttpSession session) {
        //这里如果是导师自己确认，只能看到他自己的，需要权限处理
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师看到自己的名字
            Mentor user=(Mentor) session.getAttribute("user");
            obj.setId(user.getId());
        }
        return Result.reOk("查询成功",this.service.getPageList(qPage,obj));
    }


    /**
     * 进入新增页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增保存
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(Mentor obj) {
        return this.service.insertDb(obj);
    }

    /**
     * 进入编辑页面
     * @return
     */
    @RequestMapping("/edit")
    public String edit(){
        return prefix+"/edit";
    }

    /**
     * 根据ID获取信息
     * @param id
     * @return
     */
    @RequestMapping("/getById")
    @ResponseBody
    public Result getById(Integer id) {
        Mentor dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(Mentor obj) {
        return this.service.updatesDb(obj);
    }


    /**
     * 删除保存
     * @return
     */
    @RequestMapping("/deleteId")
    @ResponseBody
    public Result deleteId(Integer id) {
        return this.service.deleteDb(id);
    }



}
