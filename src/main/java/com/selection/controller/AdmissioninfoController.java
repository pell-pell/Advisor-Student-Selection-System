package com.selection.controller;
import com.selection.entity.*;
import com.selection.entity.view.AdmissioninfoView;
import com.selection.entity.view.PretestScoresView;
import com.selection.qpage.QPage;
import com.selection.service.IAdmissioninfoService;
import com.selection.service.IApplicationPreferencesService;
import com.selection.service.IPretestScoresService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin/admissioninfo")
public class AdmissioninfoController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/admissioninfo";

    /**
     * 业务层
     */
    @Autowired
    private IAdmissioninfoService service;

    @Autowired
    private IApplicationPreferencesService iApplicationPreferencesService;

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
    public Result getList(QPage qPage, AdmissioninfoView obj, HttpSession session) {
        //考生只能查看自己的录取信息，导师只能看到报考自己的学生录取信息
        //获取当前登录的用户角色类型
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师看到已经填报属于他的学生
            //获取当前志愿表数据
            Mentor user=(Mentor) session.getAttribute("user");
            obj.setMentorId(user.getId());
        }

        if(role.equals("3")){//学生只能看到我自己的
            //获取当前志愿表数据
            CandidateInfo user=(CandidateInfo) session.getAttribute("user");
            obj.setCandidateId(user.getId());
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
    public Result insert(Admissioninfo obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师不能新增录取信息
            return Result.reError("导师不允许自己修改录取信息");
        }
        if(role.equals("3")){//学生不能新增录取信息
            return Result.reError("学生不允许自己新增录取信息");
        }
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
        Admissioninfo dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(Admissioninfo obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师不能新增录取信息
            return Result.reError("导师不允许自己修改录取信息");
        }
        if(role.equals("3")){//学生不能新增录取信息
            return Result.reError("学生不允许自己修改录取信息");
        }
        return this.service.updatesDb(obj);
    }


    /**
     * 删除保存
     * @return
     */
    @RequestMapping("/deleteId")
    @ResponseBody
    public Result deleteId(Integer id,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(!role.equals("1")){//
            return Result.reError("你无权限删除");
        }
        return this.service.deleteDb(id);
    }



}
