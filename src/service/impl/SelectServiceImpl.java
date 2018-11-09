package service.impl;

import dao.SelectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.CardFlow;
import pojo.Record;
import pojo.Result;
import pojo.User;
import service.SelectService;
import utils.ResultUtil;

import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Autowired
    private SelectDao selectDao;
    @Override
    public CardFlow selectYe(String xgh) {
        CardFlow cf =selectDao.selectYe(xgh);
        String ye = cf.getYE();
        StringBuilder sb = new StringBuilder(ye);//构造一个StringBuilder对象
        sb.insert(ye.length()-2, ".");//插入小数点
        cf.setYE(sb.toString());
//        return new StringBuffer(ye).insert(2,".").toString();
        return cf;
    }

    @Override
    public List<Record> selectRecord(String xgh) {


        return selectDao.selectRecord(xgh);
    }

    @Override
    public List<Record> selectByPageAndSelections(String xgh) {
        return selectDao.selectByPageAndSelections(xgh);
    }

    @Override
    public List<Record> selectRecoredBytime(String mintime, String maxtime, String xgh) {
        return selectDao.selectRecoredBytime(mintime,maxtime,xgh);
    }

    @Override
    public Result checkLogin(String xgh, String password) {
        User user=selectDao.checkLogin(xgh,password);
        if(user==null){
            return ResultUtil.error("该学生不存在");
        }
        //身份证截取后六位为密码
        String realpassword = user.getSFZ().substring(user.getSFZ().length() - 6);
        user.setPassword(realpassword);
        if(!password.equalsIgnoreCase(realpassword)){
            return ResultUtil.error("密码输入错误");
        }
        else return ResultUtil.success("登录成功",user);
    }


}
