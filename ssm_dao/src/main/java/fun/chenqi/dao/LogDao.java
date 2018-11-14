package fun.chenqi.dao;

import fun.chenqi.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface LogDao {

    @Insert("insert into sys_log values(common_sequence.nextval,#{visitTime},#{username},#{ip},#{method},#{executeMsg},#{executeResult},#{executeTime})")
    void saveLog(SysLog sysLog);
}
