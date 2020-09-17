package cn.xej.service.impl;

import cn.xej.entity.Blog;
import cn.xej.mapper.BlogMapper;
import cn.xej.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
