package cn.xej.service.impl;

import cn.xej.common.lang.Result;
import cn.xej.entity.Blog;
import cn.xej.entity.User;
import cn.xej.mapper.UserMapper;
import cn.xej.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public Result initUserTable(Integer currentPage) {
        Page page = new Page(currentPage,2);

        IPage pageData = userMapper.selectPage(page,new QueryWrapper<User>().orderByDesc("id"));
        System.out.println(pageData);
//        List<User> userList = userMapper.selectList(null);
        return Result.succ(pageData);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public Result deleteUser(Long id) {
        userMapper.deleteById(id);
        return Result.succ(200,"ok",null);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public Result updateUser(User user) {
        userMapper.updateById(user);
        return Result.succ(200,"ok",null);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Result addUser(User user) {
        userMapper.insert(user);
        return Result.succ(200,"添加成功",null);
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @Override
    public Result delAllUser(List<Integer> ids) {
        for (Integer id:ids){
            userMapper.deleteById(id);
        }
        return Result.succ(200,"删除成功",null);
    }
}
