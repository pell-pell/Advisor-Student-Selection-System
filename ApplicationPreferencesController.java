package com.selection.controller;
import com.selection.entity.ApplicationPreferences;
import com.selection.entity.CandidateInfo;
import com.selection.entity.Mentor;
import com.selection.entity.PretestScores;
import com.selection.entity.view.ApplicationPreferencesView;
import com.selection.entity.view.PretestScoresView;
import com.selection.qpage.QPage;
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
@RequestMapping("/api/admin/applicationpreferences")
public class ApplicationPreferencesController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/applicationpreferences";

    /**
     * 业务层
     */
    @Autowired
    private IApplicationPreferencesService service;




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
    public Result getList(QPage qPage, ApplicationPreferencesView obj, HttpSession session) {
        //报考志愿，学生只能看自己的，管理员能看大所有的，导师只能看属于报考他的学生
        //获取当前登录的用户角色类型
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师看到已经填报属于他的学生
            //获取当前志愿表数据
            Mentor user=(Mentor) session.getAttribute("user");
            obj.setPreferredMentoroneId(user.getId());
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
    public Result insert(ApplicationPreferences obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师不能新增或者修改志愿数据，只能看
            return Result.reError("导师不允许新增志愿表信息");
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
        ApplicationPreferences dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(ApplicationPreferences obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师不能新增或者修改志愿数据，只能看
            return Result.reError("导师不允许修改志愿表信息");
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
