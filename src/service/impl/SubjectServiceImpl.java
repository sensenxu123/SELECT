package service.impl;

import dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.Subject;
import service.SubjectService;
import utils.SubjectUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    /**
     * 根据学号  和 学期 信息 查询课表
     *
     * @param XH   学号
     * @param XQDM 学期代码
     */
    public List<List<List<Subject>>> findSubjectByXHAndXQDM(String XH, String XQDM) {

        String NewXQDM = findXQDMNew(); //查询出最新的学期

        List<Subject> subjectList = null;

        if (StringUtils.isEmpty(XQDM) || XQDM.equals(NewXQDM)) {
            XQDM = NewXQDM;
            subjectList = subjectDao.findSubjetByXHAndXQDM(XH, XQDM);
        }else {
            subjectList = subjectDao.findZDSubjetByXHAndXQDM(XH, XQDM);
            List<Subject> zxSubjetByXHAndXQDM = subjectDao.findZXSubjetByXHAndXQDM(XH, XQDM);
            subjectList.addAll(zxSubjetByXHAndXQDM);
        }

        //        对结果进行遍历并进行处理
        return SubjectUtil.processData(subjectList);

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
