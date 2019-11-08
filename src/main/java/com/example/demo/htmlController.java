package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 111
 * @Date: 2019/6/24 0024 下午 4:21
 * @Description:
 */
@Controller
public class htmlController {
    @RequestMapping("/xm")
    public String xmHtml(){
        return "xiaoming";
    }
    @RequestMapping("/xh")
    public String xhHtml(){
        return "xiaohua";
    }
}
