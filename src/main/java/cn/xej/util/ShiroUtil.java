package cn.xej.util;

import cn.xej.entity.User;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {


    public static User getUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
