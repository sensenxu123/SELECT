package service.impl;

import dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Subject;
import service.SubjectService;
import utils.SubjectUtil;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    /**
     *  根据学号  和 学期 信息 查询课表
     *  @param  XH  学号
     *  @param  XQDM  学期代码
     * */
    public List<List<List<Subject>>> findSubjectByXHAndXQDM(String XH, String XQDM) {

        List<Subject> subjectList = subjectDao.findSubjetByXHAndXQDM(XH, XQDM);

//        对结果进行遍历并进行处理
        return SubjectUtil.processData(subjectList);

    }

    /**
     *  查询学期代码
     * */
    public List<String> findXQDM() {
        List<String> xqdm = subjectDao.findXQDM();
        return  xqdm;
    }


}
