package cn.xej.controller;


import cn.xej.common.lang.Result;
import cn.xej.entity.Blog;
import cn.xej.entity.User;
import cn.xej.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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


    @RequiresAuthentication
    @GetMapping("/initUserTable")
    public Result initUserTable(@RequestParam(defaultValue = "1")Integer currentPage){
        return userService.initUserTable(currentPage);
    }

    @RequiresAuthentication
    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable("id")Long id){
        return userService.deleteUser(id);
    }

    @RequiresAuthentication
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequiresAuthentication
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }




    @RequiresAuthentication
    @PostMapping("/delAllUser")
    public Result delAllUser(@RequestParam(value = "ids[]", required = false) List<Integer> ids){
        return userService.delAllUser(ids);
    }


    @RequiresAuthentication
    @PostMapping("/delAll")
    public Result delAll(@RequestParam("username")String username,@RequestParam(value = "ids[]",required = false)List<Integer> ids){
        System.out.println("dhjdka");
        System.out.println(username);

        for(Integer id:ids){
            System.out.println(id);
        }
        return null;
    }

}
