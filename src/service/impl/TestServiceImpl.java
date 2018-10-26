package service.impl;

import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.CardFlow;
import pojo.User;
import service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public User getById(int i) {
        User user=testDao.getByid(i);

        return user;
    }

    @Override
    public List<CardFlow> getByXgh(String s) {
       return  testDao.getByXgh(s);
    }
}
