package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 111
 * @Date: 2019/11/9 0009 上午 9:18
 * @Description:
 */
@RestController
public class developeBR {
    @GetMapping("/dev")
    public String uutest() {
        return "This is a messageInfo from kaifa_Branch";
    }
}
