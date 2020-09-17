package cn.xej.service.impl;

import cn.xej.entity.User;
import cn.xej.mapper.UserMapper;
import cn.xej.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注作者：Alicat
 * @since 2020-09-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
