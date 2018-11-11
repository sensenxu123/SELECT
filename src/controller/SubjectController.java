package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Subject;
import service.SubjectService;
import utils.JsonUtils;
import utils.Result;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectServiceImpl;


    @RequestMapping("/findSubject")
    public  Result findSubject(@RequestParam(defaultValue = "") String XH, @RequestParam(defaultValue = "2018-20191") String XQDM){

        Result result = null;
        try {
            List<List<List<Subject>>> subjectByXHAndXQDM = subjectServiceImpl.findSubjectByXHAndXQDM(XH, XQDM);
            result = Result.ok(subjectByXHAndXQDM);
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"课表查询失败");
        }

        return  result;
    }

    /**
     *   根据学号和学期查询课表信息，如果没有学期参数，查询最新学期的课表
     *
     * */
    @RequestMapping(value = "/findSubjectJsonP",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public  String findSubject(@RequestParam(defaultValue = "") String XH, @RequestParam(defaultValue = "") String XQDM,String jsonpCallback){
        Result result = null;
        try {
            List<List<List<Subject>>> subjectByXHAndXQDM = subjectServiceImpl.findSubjectByXHAndXQDM(XH, XQDM);
            result = Result.ok(subjectByXHAndXQDM);
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"课表查询失败");
        }
        if(!StringUtils.isEmpty(jsonpCallback)) {
            return jsonpCallback+"("+ JsonUtils.objectToJson(result)+");";
        }
        return JsonUtils.objectToJson(result);
    }

/**
 *  查询学期代码
 * */
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

    /**
     *  查询学期代码 JsonP 版
     * */
    @RequestMapping("/findXQDMJonP")
    public String findXQDM(String jsonpCallback){
        Result result = null;
        try {
            List<String> xqdm = subjectServiceImpl.findXQDM();
            result = Result.ok(xqdm);
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"学期查询失败");
        }

        if(!StringUtils.isEmpty(jsonpCallback)) {
            return jsonpCallback+"("+ JsonUtils.objectToJson(result)+");";
        }
        return JsonUtils.objectToJson(result);
    }

    /**
     *  查询学年
     * */
    @RequestMapping("/findXNJonP")
    public String findXN(String jsonpCallback){
        Result result = null;
        try {
            Set<String> xn =  subjectServiceImpl.findXN();
            result = Result.ok(xn);
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"查询学年失败");
        }
        if (!StringUtils.isEmpty(jsonpCallback)){
            return jsonpCallback+"(" + JsonUtils.objectToJson(result) +")";
        }

        return JsonUtils.objectToJson(result);
    }



}
