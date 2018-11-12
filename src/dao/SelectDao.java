package dao;

import org.apache.ibatis.annotations.Param;
import pojo.CardFlow;
import pojo.Record;
import pojo.User;

import java.util.List;

public interface SelectDao {
    CardFlow selectYe(String xgh);


    List<Record> selectByPageAndSelections(String xgh);

    List<Record> selectRecoredBytime(@Param("mintime") String mintime, @Param("maxtime")String maxtime,@Param("xgh") String xgh);

    User checkLogin(@Param("xgh")String xgh, String password);
}
