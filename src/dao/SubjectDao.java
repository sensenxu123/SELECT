package dao;

import org.apache.ibatis.annotations.Param;
import pojo.BaseUser;
import pojo.Subject;

import java.util.List;

/**
 *   subject  的数据访问层
 * */
public interface SubjectDao {

    /**
     *  查询自选课
     * */
    public List<Subject> findSubjetByXHAndXQDM(@Param("XH") String XH,@Param("XQDM") String XQDM);

    /**
     *  查询学期代码
     * */
    public List<String> findXQDM();

    /**
     *  根据XGH 查询用户信息
     * */
    BaseUser findUserByXGH(@Param("XGH")String XH);

    /**
     *  根据学工号与学期 查询教师的课表
     * */
    List<Subject> findSubjetByXGHAndXQDM(@Param("XGH")String XH, @Param("XQDM")String XQDM);
}
