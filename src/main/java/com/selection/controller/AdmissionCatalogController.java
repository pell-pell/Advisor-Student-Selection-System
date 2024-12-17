package com.selection.controller;
import com.selection.entity.AdmissionCatalog;
import com.selection.entity.PrimarySubject;
import com.selection.qpage.QPage;
import com.selection.service.IAdmissionCatalogService;
import com.selection.service.IPrimarySubjectService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/admin/admissioncatalog")
public class AdmissionCatalogController {


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/admissioncatalog";

    /**
     * 业务层
     */
    @Autowired
    private IAdmissionCatalogService service;


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
    public Result getList(QPage qPage, AdmissionCatalog obj) {
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
    public Result insert(AdmissionCatalog obj, HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(!role.equals("1")){//只能看
            return Result.reError("招生目录你无权限新增");
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
        AdmissionCatalog dbo=this.service.getByIds(id);
        return Result.reOk("查询成功",dbo);
    }

    /**
     * 编辑保存
     * @return
     */
    @RequestMapping("/updates")
    @ResponseBody
    public Result updates(AdmissionCatalog obj,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(!role.equals("1")){//只能看
            return Result.reError("招生目录你无权限修改");
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
