package com.selection.controller;
import com.selection.entity.CandidateInfo;
import com.selection.entity.Mentor;
import com.selection.qpage.QPage;
import com.selection.service.ICandidateInfoService;
import com.selection.service.IMentorService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/admin/candidateinfo")
public class CandidateInfoController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/candidateinfo";

    /**
     * 业务层
     */
    @Autowired
    private ICandidateInfoService service;


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
    public Result getList(QPage qPage, CandidateInfo obj, HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(role.equals("3")){//学生看到自己的名字
            CandidateInfo user=(CandidateInfo) session.getAttribute("user");
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
    public Result insert(CandidateInfo obj) {
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
        CandidateInfo dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(CandidateInfo obj) {
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
