package com.selection.controller;
import com.selection.entity.Admissioninfo;
import com.selection.entity.Mentor;
import com.selection.entity.MentorChoiceConfirmation;
import com.selection.entity.view.AdmissioninfoView;
import com.selection.entity.view.MentorChoiceConfirmationView;
import com.selection.qpage.QPage;
import com.selection.service.IAdmissioninfoService;
import com.selection.service.IMentorChoiceConfirmationService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/admin/mentorchoiceconfirmation")
public class MentorChoiceConfirmationController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/mentorchoiceconfirmation";

    /**
     * 业务层
     */
    @Autowired
    private IMentorChoiceConfirmationService service;


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
    public Result getList(QPage qPage, MentorChoiceConfirmationView obj, HttpSession session) {
        //获取当前登录的用户角色类型
        String role=(String)session.getAttribute("role");
        if(role.equals("2")){//导师看到已经填报属于他的学生
            //获取当前志愿表数据
            Mentor user=(Mentor) session.getAttribute("user");
            obj.setMentorId(user.getId());
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
    public Result insert(MentorChoiceConfirmation obj) {
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
        MentorChoiceConfirmation dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(MentorChoiceConfirmation obj) {
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
