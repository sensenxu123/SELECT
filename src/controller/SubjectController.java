package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.BaseUser;
import pojo.Subject;
import service.SubjectService;
import utils.JsonUtils;
import utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectServiceImpl;


    @RequestMapping("/findSubject")
    public  Result findSubject(@RequestParam(defaultValue = "") String XH,HttpServletRequest request ,@RequestParam(defaultValue = "") String XQDM){
        Result result = null;
        try {
            BaseUser baseUser = (BaseUser) request.getSession().getAttribute("baseUser");
            if(baseUser == null || !baseUser.getXGH().equals(XH)) {
               result =  result.build(Result.ERROR_STATUS_CODE,"查询目标未登录");
            }else {
                List<List<List<Subject>>> subjectByXHAndXQDM = subjectServiceImpl.findSubjectByXHAndXQDM(baseUser, XQDM);
                result = Result.ok(subjectByXHAndXQDM);
            }
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
    public  String findSubject(@RequestParam(defaultValue = "") String XH, @RequestParam(defaultValue = "") String XQDM,HttpServletRequest request,String jsonpCallback){

        Result result = null;
        try {
            BaseUser baseUser = (BaseUser) request.getSession().getAttribute("baseUser");
            if(baseUser == null || !baseUser.getXGH().equals(XH)) {
                result = result.build(Result.ERROR_STATUS_CODE,"查询目标未登录");
            }else {
                List<List<List<Subject>>> subjectByXHAndXQDM = subjectServiceImpl.findSubjectByXHAndXQDM(baseUser, XQDM);
                result = Result.ok(subjectByXHAndXQDM);
            }
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
    @RequestMapping("/findXQDM" )
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
    @RequestMapping(value = "/findXQDMJonP",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
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
    @RequestMapping(value = "/findXNJonP",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
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

    /**
     * 登录
     * */
    @RequestMapping(value = "/login",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public  String  login(BaseUser baseUser,HttpServletRequest request, String jsonpCallback) {
        Result result = null;
        try {
            baseUser =  subjectServiceImpl.login(baseUser);
            if(baseUser == null) {
                result = Result.build(Result.NOTFIND_STATUS_CODE,"用户名或密码有误");
            }else {
                request.getSession().setAttribute("baseUser",baseUser);
                result = Result.ok(baseUser);
            }
        }catch (Exception e){
            result = Result.build(Result.ERROR_STATUS_CODE,"登录失败");
        }
        if (!StringUtils.isEmpty(jsonpCallback)){
            return jsonpCallback+"(" + JsonUtils.objectToJson(result) +")";
        }
        return JsonUtils.objectToJson(result);
    }


}
