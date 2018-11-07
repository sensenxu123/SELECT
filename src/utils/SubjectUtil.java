package utils;

import org.springframework.util.StringUtils;
import pojo.Subject;

import java.util.ArrayList;
import java.util.List;
/**
 *   Subject  的工具类
 *
 * */
public class SubjectUtil {

    private  final  static int WEEK_LENGTH = 7;  //一个星期的天数
    private  final  static int SECTION_LENGTH = 11;  //一天拥有的节数
    private  final  static int SECTION_SUBJECT_LENGTH = 2;// 一节中 可能出现多少种课

    /**
     *  处理 数据
     * */
    public static List<List<List<Subject>>> processData(List<Subject> subjectList) {

//      判断是否存在数据
        if(subjectList == null || subjectList.size() == 0) {
            return null;
        }

//      创建weekList,并封装数据
        List<List<List<Subject>>> weekList = createWeekList();

        for (Subject subject : subjectList) {
            int i = -1;   //weekList  的目标索引
            int j = -1;   //sectionList  的目标索引
            int sectionNum = 0;  //表示 节次
             try {
                 i = getWeekIndex(subject.getXQJ());   //获取星期索引
                 j = getSectionIndex(subject.getKSJC()); //获取节次索引
                 sectionNum = Integer.parseInt(subject.getJSJC())-Integer.parseInt(subject.getKSJC()); //计算出节次

                 List<List<Subject>> lists = weekList.get(i);//获取 星期 i 节次 list

                 subject.setZZT(disposeZZT(subject.getZZT())); //处理  Subject的信息

                 for (int m = 0;m<=sectionNum ;m++ ){
                    List<Subject> subjects = lists.get(j+m);  //动态的遍历 节List 里的数据,获取 j+m 节里的 subjectList
                     //调用方法对ZZT的数据进行处理
                     subjects.add(subject);
                 }

             }catch (Exception e){
                 e.printStackTrace();
                 throw  new RuntimeException("课表数据封装异常",e);
             }
        }

        return weekList;

    }

    /**
     *   处理ZZT 数据，并转化为 单双周，
     * */
    public static String disposeZZT(String zzt) {
        if(StringUtils.isEmpty(zzt)) {
            return zzt;
        }
        //获取前两个字符，再获取最后一个 1 的索引
        StringBuffer target = new StringBuffer();
        int startWeek = zzt.indexOf("1")+1;
        int endWeek = zzt.lastIndexOf("1")+1;
        String substring = zzt.substring(startWeek-1, startWeek+2);
        switch (substring){
            case  "111": //全上的情况
                target.append("[").append(startWeek).append("-").append(endWeek).append("]全");
                break;
            case  "101": //单双周的情况
                //判断开始startweek是奇偶数
                if(startWeek % 2 ==0) {
                    //双周
                    target.append("[").append(startWeek).append("-").append(endWeek).append("]双");
                }else {
                    //单周
                    target.append("[").append(startWeek).append("-").append(endWeek).append("]单");
                }
                break;
            default:   //复杂情况
                target.append("[").append(startWeek).append("-").append(endWeek).append("]杂");
                 break;
        }
        return target.toString();

    }


    /**
     *  创建WeekList
     *
     * */
    public static List<List<List<Subject>>>  createWeekList ( ) {
        List<List<List<Subject>>> weekList = new ArrayList(WEEK_LENGTH);   //  从 0 -- 6 表示 星期一  到 星期天
        for (int i = 0; i< WEEK_LENGTH; i++){
            List<List<Subject>> paddingSectionList  = new ArrayList<>();
            for (int j = 0; j< SECTION_LENGTH; j++){// 从 0 -- 10 表示 1  到 11 节课
                paddingSectionList.add(new ArrayList<Subject>(SECTION_SUBJECT_LENGTH));
            }
            weekList.add(paddingSectionList);
        }
        return weekList;
    }


    /**
     *  传入章节标志， 获取 节 List  指定的索引
     * */
    public  static int getSectionIndex(String  ksjc) throws Exception {
        int j = -1;
        switch (ksjc){   //  3  7 两次，理论上不存在执行的可能
            case  "1":j= 0;; break;
            case  "2":j= 1;break;
            case  "3":j= 2;break;
            case  "4":j= 3;break;
            case  "5":j= 4;break;
            case  "6":j= 5;break;
            case  "7":j= 6;break;
            case  "8":j= 7;break;
            case  "9":j= 8;break;
            case  "10":j= 9;break;
            case  "11":j=10;break;
            default: throw  new Exception("课程所在节数有误");
        }
        return  j;
    }


    /**
     *  传入星期标志  获取星期List 指定的索引
     * */
    public  static  int getWeekIndex(String xqj) throws Exception {
        int i = -1;
        switch (xqj){
            case  "1":i= 0; break;
            case  "2":i= 1;break;
            case  "3":i= 2;break;
            case  "4":i= 3;break;
            case  "5":i= 4;break;
            case  "6":i= 5;break;
            case  "7":i= 6;break;
            default: throw  new Exception("课程所在星期数有误");
        }
        return  i;
    }

    /**
     *  填充无效数据
     *  获取指定长度的，填充了指定类型数据的集合
     * */
    public    static  <T>  List<T> getPaddingList(T padding,int size) {

        List<T> paddingList = new ArrayList<>(size);

        for (int i = 0;i<size;i++){
            paddingList.add(padding);
        }

        return  paddingList;
    }

}
