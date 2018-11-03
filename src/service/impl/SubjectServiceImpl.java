package service.impl;

import dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.BaseUser;
import pojo.Subject;
import service.SubjectService;
import utils.SubjectUtil;
import utils.UserUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    private static final  String USER_SFMC_TEACHER = "教师";

    @Autowired
    private SubjectDao subjectDao;

    /**
     * 根据学号  和 学期 信息 查询课表
     *
     * @param baseUser   用户信息
     * @param XQDM 学期代码
     */
    public List<List<List<Subject>>> findSubjectByXHAndXQDM(BaseUser baseUser, String XQDM) {

        if(baseUser == null || StringUtils.isEmpty(baseUser.getXGH())) {
            return null;
        }

        List<Subject> subjectList = null;

        if (StringUtils.isEmpty(XQDM)) {
            XQDM = findXQDMNew(); //查询出最新的学期
        }
        //根据XH查询身份信息
        if ( baseUser.getSFMC().equals(USER_SFMC_TEACHER)){
            subjectList = subjectDao.findSubjetByXGHAndXQDM(baseUser.getXGH(),XQDM); // 此时，XH 中存放是老师的XGH
        }else {
            subjectList = subjectDao.findSubjetByXHAndXQDM(baseUser.getXGH(),XQDM);
        }

        //        对结果进行遍历并进行处理
        return SubjectUtil.processData(subjectList);

    }

    /**
     *   根据学号查询 用户信息
     * */
    public BaseUser findUserByXGH(String XGH) {
            BaseUser baseUser = null;
            baseUser = subjectDao.findUserByXGH(XGH);
            return  baseUser;
    }

    @Override
    public BaseUser login(BaseUser baseUser) {
        if(baseUser == null || StringUtils.isEmpty(baseUser.getXGH()) || StringUtils.isEmpty(baseUser.getPassword()) ) {
            throw  new RuntimeException("用户名或密码为空"); //这是不正常现象，前台应该是有非空校验，出现这种现象，属于非法访问(或其他异常情况)
        }
        BaseUser userByXGH = subjectDao.findUserByXGH(baseUser.getXGH());
        userByXGH = UserUtil.checkUser(baseUser,userByXGH); //校验用户名、密码，若正确返回用户信息，若错误，返回null
        return userByXGH;
    }


    /**
     * 查询学期代码，
     */
    public List<String> findXQDM() {
        List<String> xqdm = subjectDao.findXQDM();
        return xqdm;
    }

    /**
     * 查询学年
     */
    public Set<String> findXN() {
        List<String> xqdm = findXQDM(); //学期代码

        Set<String> xn = new HashSet<>();  //学年

        for (String xq : xqdm) {
            xn.add(xq.substring(0, xq.length() - 1)); //截取学年
        }
        return xn;
    }

    /**
     * 查询最新的学期信息
     */
    public String findXQDMNew() {
        List<String> xqdm = findXQDM();
        String result = xqdm.get(0);
        for (String xq : xqdm) {
            if (result.compareTo(xq) < 0) {
                result = xq;
            }
        }
        return result;
    }

}
