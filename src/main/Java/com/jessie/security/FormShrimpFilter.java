package com.jessie.security;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.springframework.stereotype.Service;

import com.jessie.security.SystemAuthorizingRealm.Principal;
import com.jessie.util.UserUtils;


/**
 * 表单验证（包含验证码）过滤类
 */
@Service
public class FormShrimpFilter extends AdviceFilter {

    private String redirectUrl = "http://url/portal";//session 失效之后需要跳转的页面
    private String platformUrl = "http://url/kms/a/login";
    //排除这个链接 其他的链接都会进行拦截
    private String loginUrl = "modules/sys/sysLogin";

    protected boolean preHandle(ServletRequest request, ServletResponse response, String username, String password, String registAccountType) {
        Principal principal = UserUtils.getPrincipal();
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        System.out.println(username);
        System.out.println(password);
        System.out.println(registAccountType);
//        if(checkUrl(uri, loginUrl,frontUrl,uploadUrl,appUrl)|(principal!=null&&!principal.isMobileLogin())){
//            
//            return true;
//        }

        try {
            issueRedirect(request, response, redirectUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl)
            throws Exception {

        String url = "<a href=" + redirectUrl + " target=\"_blank\" onclick=\"custom_close()\">重新登录<a/> ";
        String platform = "<a href=" + platformUrl + " target=\"_blank\" onclick=\"custom_close()\">直接登录<a/> ";

        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<script language='javascript'>");
        out.print("function custom_close(){" +
                "self.opener=null;" +
                "self.close();}");
        out.print("</script>");
        out.print("没有权限或者验证信息过期，请点击" + url + "登录portal<br/>");
        out.print("直接登录" + platform);
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

}