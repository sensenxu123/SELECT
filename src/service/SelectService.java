package service;

import pojo.CardFlow;
import pojo.Record;
import pojo.Result;

import java.util.List;

public interface SelectService {
    CardFlow selectYe(String xgh);


    List<Record> selectByPageAndSelections(String xgh);

    List<Record> selectRecoredBytime(String mintime, String maxtime, String xgh);

    Result checkLogin(String xgh,String password);
}
