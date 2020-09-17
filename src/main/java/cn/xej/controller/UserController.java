package cn.xej.controller;


import cn.xej.common.lang.Result;
import cn.xej.entity.User;
import cn.xej.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注作者：Alicat
 * @since 2020-09-16
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1);
        return Result.succ(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        return Result.succ(user);
    }

}
