package be.ipeters.mbcrudweb.dao;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface SysDateMapper {
    @Select("select SYSDATE() from DUAL")
    public Date getCurrentDateAndTime();

}
