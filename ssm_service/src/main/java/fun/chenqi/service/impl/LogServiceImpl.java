package fun.chenqi.service.impl;

import fun.chenqi.dao.LogDao;
import fun.chenqi.domain.SysLog;
import fun.chenqi.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogDao dao;


    @Override
    public void saveLog(SysLog sysLog) {
        System.out.println(sysLog);
        dao.saveLog(sysLog);
    }
}
