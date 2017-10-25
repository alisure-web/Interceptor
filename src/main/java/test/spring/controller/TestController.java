package test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ALISURE on 2017/3/17.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index.html")
    public String Index(){
        System.out.println("TestController Index for /index.html");
        return  "index";
    }

    @RequestMapping("/admin/*")
    public String Index2(){
        System.out.println("TestController Index for /**");
        return  "index";
    }
}
