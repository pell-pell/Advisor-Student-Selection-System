package com.selection.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面入口控制层
 */
@Controller
@RequestMapping("/sys/main")
public class MainController {

    /**
     * 资源路径
     */
    public String view="/view/admin";
    /**
     * 日志记录
     */
    private static final Logger log =  LoggerFactory.getLogger(MainController.class);

    /**
     * 进入首页
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return view+"/index";
    }

    /**
     * 进入首页
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return view+"/welcome";
    }


}
