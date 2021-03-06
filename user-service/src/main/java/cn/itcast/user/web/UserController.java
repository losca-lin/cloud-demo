package cn.itcast.user.web;

import cn.itcast.user.config.MyConfig;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
//开启热更新
//@RefreshScope
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    MyConfig myConfig;

    @Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("/getMyConfig")
    public MyConfig getMyConfig(){
        return myConfig;
    }
    @GetMapping("/date")
    public String date(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(myConfig.getDateformat()));
    }
    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */


    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) throws InterruptedException {
        if (id == 1){
            Thread.sleep(60);
        }else if (id == 2){
            throw new RuntimeException("故意抛弃异常");
        }
        return userService.queryById(id);
    }
}
