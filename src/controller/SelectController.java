package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.*;
import service.SelectService;
import utils.JsonUtils;
import utils.ResultUtil;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/select")
public class SelectController {
    @Autowired
    private SelectService selectService;
    @RequestMapping(value="/selectYe",produces = "application/json;charset=utf-8")
    //这个方法是查询账户的余额
    @ResponseBody
    public String selectYe(String xgh,String callback){
        CardFlow cf=selectService.selectYe(xgh);
        /*判断是否使用jsonP*/

        if(StringUtils.isNotBlank(callback)){
            return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",cf))+");";
        }
        else return JsonUtils .objectToJson(ResultUtil.error("查询失败"));
    }

    @RequestMapping(value="/checklogin",produces = "application/json;charset=utf-8")
    //这个方法是校验登录
    @ResponseBody
    public String login(String xgh,String password,String callback,HttpSession session){
        Result result=selectService.checkLogin(xgh,password);
        return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",result))+");";
    }

    //pageHelper的测试使用
    @RequestMapping(value="/selectRecord",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectRecord(String xgh,HttpSession session,String callback) {
        int pageSize=20;
        //先从session中拿出time 如果没有则为默认查询当月
            List<Record> docs = selectService.selectByPageAndSelections(xgh);

            return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",docs))+");";

    }



    @RequestMapping(value="/selectRecoredBytime",produces = "application/json;charset=utf-8")
    //这个方法是查询账户的明细
    public String selectRecoredBytime(String xgh,String mintime,String maxtime,HttpSession session,String callback){
        //将两个时间放入session域中

        List<Record> recordList= selectService.selectRecoredBytime(mintime,maxtime,xgh);

        return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",recordList))+");";

    }



}
