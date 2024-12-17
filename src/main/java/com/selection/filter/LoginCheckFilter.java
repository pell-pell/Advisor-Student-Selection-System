package com.selection.filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 定义过滤器名称和定义过滤路径
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter { // 实现javax.servlet下的Filter

    //1.定义路径匹配器--用于下方的checkPath()方法匹配请求路径和放行路径是否存在匹配（固定写法）。
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 重写其中的doFilter方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //2.将参数servlet转为http形式,因为下面要操作session
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //3.获取当前访问的URL，用以判断是否直接放行
        String requestURI = request.getRequestURI();
        log.info("当前的URI是：{}", requestURI);

        //4.定义直接放行的资源请求(根据自己实际情况定义放行的资源)
        String[] urls = new String[]{
                //登录页面的请求
                "/register.html",
                "/login.html",
                //下方访问静态页面可以放行，但是在静态页面发送的分页数据请求是会过滤的
                //例如:当一访问manege页面就会请求获取分页数据，就会向/users发送
                //请求，然会就会进行登录检查
                "/static/**",
                "/css/**",
                "/lib/**",
                "/images/**",
                "/js/**",
                "/favicon.ico",
                "/api/code/getVerify.do",
                "/api/login/login.do",
                "/api/login/register.do",
                "/error/500.html",
                "/error/404.html",
                "/view/front/**",
                "/front/static/**",
                "/api/front/**"
        };

        //步骤5在最下面（定义方法）
        //6.检查当前请求是否需要进行过滤（true代表匹配成功，直接放行）
        if (checkPath(urls, requestURI)) {
            //如果匹配成功，则放行
            filterChain.doFilter(request, response);
            log.info("资源直接放行...");
            return;
        }

        //7.捕获到需要过滤的请求，检查是否有登录后赋予的session（检查是否已登录）
        if (request.getSession().getAttribute("user")!=null) { //“login”是登录接口定义的session名
            filterChain.doFilter(request, response);
            log.info("用户已登录...");
            return;
        }

        //8.如果无session，登录失败，可以给予前端一些提示
        response.sendRedirect("/login.html");
        log.info("请求过滤成功，登录失败...");
    }

    @Override
    public void destroy() {

    }

    //5.定义路径匹配方法，传入放行请求路径数组和当前请求路径进行匹配。

    /**
     * 路径匹配方法
     *
     * @param urls      需要放行的请求路径数组
     * @param targetUrl 需要检查的请求路径
     * @return 返回是否匹配成功
     */
    private Boolean checkPath(String[] urls, String targetUrl) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, targetUrl)) {
                return true;
            }
        }
        return false;
    }
}