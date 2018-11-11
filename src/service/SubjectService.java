package service;

import pojo.Subject;

import java.util.List;
import java.util.Set;

public interface SubjectService {

    public List<List<List<Subject>>> findSubjectByXHAndXQDM (String XH, String XQDM);

    public List<String> findXQDM();

    public Set<String > findXN();

    public String findXQDMNew();
}
