package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 111
 * @Date: 2019/11/9 0009 上午 9:05
 * @Description:
 */
@RestController
public class chuizige {
    @GetMapping("/addtest")
    public String uutest() {
        return "MessgeInfo:just for testing";
    }
    @GetMapping("/wl")
    public String wl() {
        return "Webhook is success!";
    }
    @GetMapping("/wl1")
    public String wl1() {
        return "Webhook is success!111111111111";
    }
    @GetMapping("/wle")
    public String wle() {
        return "解决403！嗯哼";
    }
}
