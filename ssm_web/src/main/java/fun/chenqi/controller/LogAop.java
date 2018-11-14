package fun.chenqi.controller;

import fun.chenqi.domain.SysLog;
import fun.chenqi.domain.SysUser;
import fun.chenqi.service.ILogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Aspect 切面的注解
 * @Component 将当前切面类交给容器管理
 */
@Aspect
@Component
public class LogAop {
    @Autowired
    HttpServletRequest request;
    @Autowired
    ILogService service;

    SysLog log;

    // 定义切面类的切入点 指定拦截的方法规则
    @Pointcut("execution(* fun.chenqi.controller.*.*(..))")
    public void po() {
    }

    // 前置通知
    @Before("po()")
    public void before(JoinPoint jp) {
        log = new SysLog();
        // 获取访问时间
        log.setVisitTime(new Date());
        //通过request获取ip
        log.setIp(request.getRemoteAddr());
        //获取当前登录的用户名
        //后台获取权限框架存储的用户对象
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        log.setUsername(user.getUsername());
        //获取正在访问的类和方法
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        log.setMethod(className + "/" + methodName);
    }

    //后置通知
    @AfterReturning("po()")
    public void afterReturning() {
        log.setExecuteTime(new Date().getTime() - log.getVisitTime().getTime());
        log.setExecuteResult("Success");
        log.setExecuteMsg("执行成功！");
        service.saveLog(log);
    }

    // 异常通知
    @AfterThrowing(value = "po()", throwing = "e")
    public void afterThrowing(Exception e) {
        log.setExecuteTime(new Date().getTime() - log.getVisitTime().getTime());
        log.setExecuteResult("exception");
        log.setExecuteMsg(e.getMessage());
        service.saveLog(log);
    }


}
