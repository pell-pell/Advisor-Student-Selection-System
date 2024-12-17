package com.selection.controller;

import com.selection.entity.Admin;
import com.selection.entity.CandidateInfo;
import com.selection.entity.Mentor;
import com.selection.service.IAdminService;
import com.selection.service.ICandidateInfoService;
import com.selection.service.IMentorService;
import com.selection.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IAdminService iAdminService;

    @Autowired
    private IMentorService iMentorService;

    @Autowired
    private ICandidateInfoService iCandidateInfoService;

    /**
     * 系统PC平台用户登陆
     * @param request
     * @param response
     * @return
     */
    @CrossOrigin
    @RequestMapping(value="/login")
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response){
        String userAccount = request.getParameter("userAccount");
        if(StringUtils.isEmpty(userAccount)){
            return Result.reError("账号不能为空");
        }
        String userPwd =  request.getParameter("userPwd");
        if(StringUtils.isEmpty(userPwd)){
            return Result.reError("密码不能为空");
        }
        String userRole=request.getParameter("userRole");
        if(StringUtils.isEmpty(userRole)){
            return Result.reError("角色不能为空");
        }
        if(userRole.equals("1")){//管理员
            Admin user=this.iAdminService.login(userAccount,userPwd);
            if(user==null){
                return Result.reError("账号密码错误！！！");
            }
            request.getSession().setAttribute("user",user);
        }
        if(userRole.equals("2")){//导师
            Mentor user=this.iMentorService.login(userAccount,userPwd);
            if(user==null){
                return Result.reError("账号密码错误！！！");
            }
            request.getSession().setAttribute("user",user);
        }
        if(userRole.equals("3")){//考生
            CandidateInfo user=this.iCandidateInfoService.login(userAccount,userPwd);
            if(user==null){
                return Result.reError("账号密码错误！！！");
            }
            request.getSession().setAttribute("user",user);
        }
        request.getSession().setAttribute("role",userRole);
        return Result.reOk("登录成功");
    }



    /**
     * 获取当前登录的用户信息
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo(HttpSession session) {
        Map<String,Object> objectMap=new HashMap<>();
        String role=(String)session.getAttribute("role");
        objectMap.put("type",role);
        if(role.equals("1")) {
            Admin user=(Admin) session.getAttribute("user");
            objectMap.put("user",user);
        }
        if(role.equals("2")) {
            Mentor user=(Mentor) session.getAttribute("user");
            objectMap.put("user",user);
        }
        if(role.equals("3")) {
            CandidateInfo user=(CandidateInfo) session.getAttribute("user");
            objectMap.put("user",user);
        }
        return Result.reOk("查询成功",objectMap);
    }


    /**
     * 修改当前登录的用户信息
     * @return
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public Result updateUserInfo(Admin admin,Mentor mentor,CandidateInfo candidateInfo,HttpSession session) {
        String role=(String)session.getAttribute("role");
        if(role.equals("1")) {
            this.iAdminService.updatesDb(admin);
            //刷新用户
            Admin db=this.iAdminService.getById(admin.getId());
            session.setAttribute("user",db);
        }
        if(role.equals("2")) {
            this.iMentorService.updatesDb(mentor);
            //刷新用户
            Mentor db=this.iMentorService.getById(mentor.getId());
            session.setAttribute("user",db);
        }
        if(role.equals("3")) {
            this.iCandidateInfoService.updatesDb(candidateInfo);
            //刷新用户
            CandidateInfo db=this.iCandidateInfoService.getById(candidateInfo.getId());
            session.setAttribute("user",db);
        }
        return Result.reOk("修改成功");

    }


    /**
     * 路由地址
     */
    public String prefix = "/view/admin/account";

    /**
     * 进入管理页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return prefix+"/index";
    }


}
