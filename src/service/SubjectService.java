package service;

import pojo.Subject;

import java.util.List;

public interface SubjectService {

    public List<List<List<Subject>>> findSubjectByXHAndXQDM (String XH, String XQDM);

    public List<String> findXQDM();
}
