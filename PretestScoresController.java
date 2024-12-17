package com.selection.controller;
import com.selection.entity.*;
import com.selection.entity.view.PretestScoresView;
import com.selection.qpage.QPage;
import com.selection.service.IApplicationPreferencesService;
import com.selection.service.IPretestScoresService;
import com.selection.service.IPrimarySubjectService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin/pretestscores")
public class PretestScoresController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/pretestscores";

    /**
     * 业务层
     */
    @Autowired
    private IPretestScoresService service;

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
    public Result getList(QPage qPage, PretestScoresView obj, HttpSession session) {
        //获取成绩，当前考生只能看到自己成绩，导师只能看到报考他的学生，管理员可以看到所有的
        //获取当前登录的用户角色类型
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师看到已经填报属于他的学生
            //获取当前志愿表数据
            Mentor user=(Mentor) session.getAttribute("user");
            List<ApplicationPreferences> applicationPreferencesList=this.iApplicationPreferencesService.getMentorById(user.getId());
            List<Integer> candList=null;
            if(applicationPreferencesList!=null&&applicationPreferencesList.size()>=1){//证明已经有学生选择了这个导师
                candList=new ArrayList<>();
                for (ApplicationPreferences applicationPreferences : applicationPreferencesList) {
                    candList.add(applicationPreferences.getCandidateId());//存入学生ID
                }
                obj.setCandList(candList);
            }
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
    public Result insert(PretestScores obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(!role.equals("1")){//
            return Result.reError("你无权限新增成绩");
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
        PretestScores dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(PretestScores obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(!role.equals("1")){//
            return Result.reError("你无权限修改成绩");
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
