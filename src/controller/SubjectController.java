package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Subject;
import service.SubjectService;
import utils.Result;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectServiceImpl;


    @RequestMapping("/findSubject")
    public  Result findSubject(@RequestParam(defaultValue = "16038116") String XH, @RequestParam(defaultValue = "2018-20191") String XQDM){

        Result result = null;
        try {
            List<List<List<Subject>>> subjectByXHAndXQDM = subjectServiceImpl.findSubjectByXHAndXQDM(XH, XQDM);
            result = Result.ok(subjectByXHAndXQDM);
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"课表查询失败");
        }
        return  result;
    }


    @RequestMapping("/findXQDM")
    public Result findXQDM(){
        Result result = null;
        try {
            List<String> xqdm = subjectServiceImpl.findXQDM();
            result = Result.ok(xqdm);
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"学期查询失败");
        }
        return result;
    }



}
