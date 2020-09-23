package cn.xej.service;

import cn.xej.common.lang.Result;
import cn.xej.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注作者：Alicat
 * @since 2020-09-16
 */
public interface UserService extends IService<User> {
    List<User> getAllUsers();

    Result initUserTable(Integer currentPage);

    Result deleteUser(Long id);

    Result updateUser(User user);

    Result addUser(User user);

    Result delAllUser(List<Integer> ids);
}
