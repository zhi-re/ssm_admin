package fun.chenqi.service;

import fun.chenqi.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ISysUserService extends UserDetailsService {

    List<SysUser> findAllUser();

    void save(SysUser user);

    SysUser findOne(Long id);
}
