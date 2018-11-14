package fun.chenqi.service.impl;

import fun.chenqi.dao.PermissionDao;
import fun.chenqi.domain.Permission;
import fun.chenqi.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionDao dao;

    @Override
    public List<Permission> findAllPermission() {

        return dao.findAllPermission();
    }

    @Override
    public void save(Permission permission) {
        dao.save(permission);
    }
}
