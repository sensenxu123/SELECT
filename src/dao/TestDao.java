package dao;

import pojo.CardFlow;
import pojo.User;

import java.util.List;

public interface TestDao {
    User getByid(int i);

    List<CardFlow> getByXgh(String s);
}
