package service;

import pojo.BaseUser;
import pojo.Subject;

import java.util.List;
import java.util.Set;

public interface SubjectService {

    public List<List<List<Subject>>> findSubjectByXHAndXQDM (BaseUser baseUser, String XQDM);

    public List<String> findXQDM();

    public Set<String > findXN();

    public String findXQDMNew();

    public BaseUser findUserByXGH(String XGH);

    BaseUser login(BaseUser baseUser);

}
