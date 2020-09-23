package cn.xej.mapper;

import cn.xej.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注作者：Alicat
 * @since 2020-09-16
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> getAllUsers();
}
