package cn.jiyun.controller;

import cn.jiyun.pojo.User;
import cn.jiyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.List;

@RestController
@RequestMapping("consumer/user")
public class ConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    @HystrixCommand//(fallbackMethod = "getUsersFallBack")
    public String findAll(@RequestParam("ids") List<Long> ids){
         return this.userService.queryUserByIds(ids).toString();
    }

}
