package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.CardFlow;
import pojo.User;
import service.TestService;

import java.util.List;

@Controller
@RequestMapping("/show")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/showuser")
    public void test(){
       User user= testService.getById(1);

        System.out.println(user);

    }
    @RequestMapping("/showxm")
    public void test1(){
      List<CardFlow> list=testService.getByXgh("16035049");
        System.out.println(list);
    }

}
