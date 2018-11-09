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
    public String login(String xgh,String password,String callback){
        Result result=selectService.checkLogin(xgh,password);
        return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",result))+");";
    }

    //pageHelper的测试使用
    @RequestMapping(value="/selectRecord",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectRecord(String xgh,HttpSession session,String callback) {
        //先从session中拿出time 如果没有则为默认查询当月
        String mintime = (String) session.getAttribute("mintime");
        String maxtime = (String) session.getAttribute("maxtime");
        int pageSize=20;
        if(mintime==null&&maxtime==null){
//            //固定显示条数
//            if(currentPage==0)currentPage=1;
//            PageHelper.startPage(currentPage, pageSize);
            List<Record> docs = selectService.selectByPageAndSelections(xgh);
//            PageInfo<Record> pageInfo = new PageInfo<>(docs);
//            //从查询中获取总页数
//            int pages = pageInfo.getPages();
//            int total =(int) pageInfo.getTotal();
//            //将总页数，第几页，每页显示条数写入PageBean实体
//            PageBean<Object> pageBean = new PageBean<>(currentPage,pageSize,total,pages);
//            List<Record> list = pageInfo.getList();
//            //索引list
//            int count=(currentPage-1)*20;
//            List<Integer> integerList=new ArrayList<>();
//            for(int i=1;i<=list.size();i++){
//                integerList.add(count+i);
//            }
//            List list1=new ArrayList();
//            list1.add(list);
//            list1.add(integerList);
//            list1.add(pageBean);
            return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",docs))+");";
        }
        else{
//            PageHelper.startPage(currentPage, pageSize);
            List<Record> recordList= selectService.selectRecoredBytime(mintime,maxtime,xgh);
//            PageInfo<Record> pageInfo = new PageInfo<>(recordList);
//            List<Record> list = pageInfo.getList();
            //从查询中获取总页数ml;
//            int pages = pageInfo.getPages();
//            int total =(int) pageInfo.getTotal();
//            PageBean<Object> pageBean = new PageBean<>(currentPage,pageSize,total,pages);
//            int count=(currentPage-1)*20;
//            List<Integer> integerList=new ArrayList<>();
//            for(int i=1;i<=list.size();i++){
//                integerList.add(count+i);
//            }
//            List list1=new ArrayList();
//            list1.add(list);
//            list1.add(integerList);
//            list1.add(pageBean);
            return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",recordList))+");";
        }







//        ModelAndView mv = new ModelAndView();
//        mv.addObject("list",list);
//        mv.addObject("integerList",integerList);
//        mv.addObject("pageBean",pageBean);
//        mv.setViewName("test");
    }
    @RequestMapping(value="/selectRecoredBytime",produces = "application/json;charset=utf-8")
    //这个方法是查询账户的明细
    public String selectRecoredBytime(String xgh,String mintime,String maxtime,HttpSession session,String callback){
        //将两个时间放入session域中
        session.setAttribute("mintime",mintime);
        session.setAttribute("maxtime",maxtime);
//        int currentPage=1;
//        int pageSize=20;
//        PageHelper.startPage(currentPage, pageSize);
        List<Record> recordList= selectService.selectRecoredBytime(mintime,maxtime,xgh);
//        PageInfo<Record> pageInfo = new PageInfo<>(recordList);
//        List<Record> list = pageInfo.getList();
//        //从查询中获取总页数ml;mklmkn
//        int pages = pageInfo.getPages();
//        int total =(int) pageInfo.getTotal();
//        PageBean<Object> pageBean = new PageBean<>(currentPage,pageSize,total,pages);
//        int count=(currentPage-1)*20;
//        List<Integer> integerList=new ArrayList<>();
//        for(int i=1;i<=list.size();i++){
//            integerList.add(count+i);
//        }
//        List list1=new ArrayList();
//        list1.add(list);
//        list1.add(integerList);
//        list1.add(pageBean);
        return callback+"("+JsonUtils.objectToJson(ResultUtil.success("查询成功",recordList))+");";

    }
}
