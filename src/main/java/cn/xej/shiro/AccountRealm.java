package cn.xej.shiro;

import cn.hutool.core.bean.BeanUtil;
import cn.xej.entity.User;
import cn.xej.service.UserService;
import cn.xej.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("4444444444444444444");
        JwtToken jwtToken = (JwtToken) authenticationToken;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));
        if(user == null){
            throw new UnknownAccountException("账户不存在");
        }
        if (user.getStatus() == -1){
            throw new LockedAccountException("账户已被锁定");
        }

        return new SimpleAuthenticationInfo(user,jwtToken.getCredentials(),getName());

    }
}
