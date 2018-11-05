package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Subject;

import java.util.List;

/**
 *   subject  的数据访问层
 * */
public interface SubjectDao {

    /**
     *  查询课表
     * */
    public List<Subject> findSubjetByXHAndXQDM(@Param("XH") String XH,@Param("XQDM") String XQDM);

    /**
     *  查询学期代码
     * */
    public List<String> findXQDM();


}
