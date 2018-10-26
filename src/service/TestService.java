package service;

import pojo.CardFlow;
import pojo.User;

import java.util.List;

public interface TestService {
    User getById(int i);

    List<CardFlow> getByXgh(String s);
}
