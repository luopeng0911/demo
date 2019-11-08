package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: 111
 * @Date: 2019/6/19 0019 下午 3:38
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class MyGetCookieController {
    /**
     * @param response
     * @return
     * @Auther:lp
     * @method:
     */
    @GetMapping("/uu")
    public String uutest(String cookv1) {
        String par1 = cookv1;
        return "消息: "+cookv1;
    }
    @GetMapping("/setCookies")
    public String setCookies(HttpServletRequest request,HttpServletResponse response, String cookv1) {
        String par1 = cookv1;
        Cookie cookie1 = new Cookie("sessionId", par1);
        cookie1.setMaxAge(300);
        response.addCookie(cookie1);
        return "cookies信息添加成功";
    }
    @GetMapping("/setSeeion")
    public String setSeeion(HttpServletRequest request,HttpServletResponse response) {
            HttpSession httpSession=request.getSession();
            httpSession.setAttribute("sessionId","NiGouDan");
            httpSession.setMaxInactiveInterval(60);
            return "Session And Cookie Add Success!";
    }
    @GetMapping("/GetSeeion")
    public String GetSeeion(HttpServletRequest request,HttpServletResponse response) {
        HttpSession httpSession=request.getSession(false);
        if (httpSession !=null) {
            return httpSession.getId();
        }
        else  return  "Session is null";
    }
    @GetMapping("/ivseeion")
    public String ivseeion(HttpServletRequest request,HttpServletResponse response) {
        HttpSession httpSession=request.getSession();
        httpSession.invalidate();
        return "clear success!";
    }

    @GetMapping("/getCookies")
    public String getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String resultC ="";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                resultC+=cookie.getValue()+" ";
            }
            return resultC;
        }
        return "No cookies!";
    }

    @GetMapping("/testCookies")
    public void testCookies(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        HttpSession httpSession=request.getSession(false);
        String cookieValue;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    cookieValue = cookie.getValue();
                    if (cookieValue.equals(httpSession.getAttribute("sessionId"))) {
                        response.sendRedirect("http://127.0.0.1:8080/test/rd1");
                    }
                }
            }
        }
        else response.sendRedirect("http://127.0.0.1:8080/test/rd3");
    }
    @GetMapping("/rd1")
    public String getrd1() {
        return "Hi ! NiGouDan";
    }

    @GetMapping("/rd3")
    public String getrd3() {
        return "Invalid cookie!";
    }

    @GetMapping("/")
    public String testPort() {
        return "Application is running!";
    }


}
