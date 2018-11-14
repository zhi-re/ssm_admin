package fun.chenqi.service.impl;

import fun.chenqi.dao.RoleDao;
import fun.chenqi.dao.SysDao;
import fun.chenqi.domain.Role;
import fun.chenqi.domain.SysUser;
import fun.chenqi.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysDao dao;
    @Autowired
    private RoleDao roleDao;

    /**
     * 该方法是认证的方法
     * 先编写一个默认的认证代码
     * 参数就是表单提交的用户名
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // todo 通过用户名查询密码和 具有的权限
        SysUser sysUser = dao.fundByName(username);
        // 真的权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        // todo 错误写法！不要查询所有权限 要查询该用户具有权限
        // List<Role> roleList = roleDao.findAllRole();
        List<Role> roleList = sysUser.getRoles();
        // 判断所有权限是否为空
        if (roleList != null && roleList.size() > 0) {
            for (Role role : roleList) {
                // 不为空 传入角色
                authorities.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase()));
            }
        }

        // 给一个假的权限authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN "));

        // 创建用户
        // 修改登录的方法，把{noop}代码去掉，表示采用加密方式登录
        //User user = new User(username, "{noop}" + sysUser.getPassword(), authorities);
        // User user = new User(username, sysUser.getPassword(), authorities);

        /*修改userService实现类 在登录时候根据数据库状态赋予User对象的状态验证属性
         中间的4个boolean属性含义为：默认都是true 代表可用
        账号是否可用
                账号是否过期
        密码是否过期
                账号是否锁定*/
        User user = new User(username, sysUser.getPassword(), sysUser.getStatus() == 1 ? true : false, true, true, true, authorities);

        return user;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<SysUser> findAllUser() {
        return dao.findAllUser();
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void save(SysUser user) {
        dao.save(user);

    }

    /**
     * 查询用户详情
     *
     * @param id
     * @return
     */
    @Override
    public SysUser findOne(Long id) {
        SysUser user = dao.findOne(id);
        return user;
    }
}
