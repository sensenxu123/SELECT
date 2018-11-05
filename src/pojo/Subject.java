package pojo;

import java.io.Serializable;

/**
 *   科目实体
 *          用于封装，课程的一些信息
 * */
public class Subject implements Serializable {

    private    String    XSXM    ;     //学生姓名
    private    String    KCMC    ;     //课程名称
    private    String    ZZT     ;     //上课周次
    private    String    XQJ     ;      //星期几
    private    String    KSJC    ;		  //开始节次
    private    String    JSJC    ;        //结束节次
    private    String    KSSJ    ;        //开始时间
    private    String    JSXM    ;        //教师姓名
    private    String    JSGH    ;        //教师工号
    private    String    SKJSMC    ;      //上课教室名称
    private    String    SKJSDM    ;   //上课教室代码


    public Subject() {
    }

    public Subject(String XSXM, String KCMC, String ZZT, String XQJ, String KSJC, String JSJC, String KSSJ, String JSXM, String JSGH, String SKJSMC, String SKJSDM) {
        this.XSXM = XSXM;
        this.KCMC = KCMC;
        this.ZZT = ZZT;
        this.XQJ = XQJ;
        this.KSJC = KSJC;
        this.JSJC = JSJC;
        this.KSSJ = KSSJ;
        this.JSXM = JSXM;
        this.JSGH = JSGH;
        this.SKJSMC = SKJSMC;
        this.SKJSDM = SKJSDM;
    }

    public String getXSXM() {
        return XSXM;
    }

    public void setXSXM(String XSXM) {
        this.XSXM = XSXM;
    }

    public String getKCMC() {
        return KCMC;
    }

    public void setKCMC(String KCMC) {
        this.KCMC = KCMC;
    }

    public String getZZT() {
        return ZZT;
    }

    public void setZZT(String ZZT) {
        this.ZZT = ZZT;
    }

    public String getXQJ() {
        return XQJ;
    }

    public void setXQJ(String XQJ) {
        this.XQJ = XQJ;
    }

    public String getKSJC() {
        return KSJC;
    }

    public void setKSJC(String KSJC) {
        this.KSJC = KSJC;
    }

    public String getJSJC() {
        return JSJC;
    }

    public void setJSJC(String JSJC) {
        this.JSJC = JSJC;
    }

    public String getKSSJ() {
        return KSSJ;
    }

    public void setKSSJ(String KSSJ) {
        this.KSSJ = KSSJ;
    }

    public String getJSXM() {
        return JSXM;
    }

    public void setJSXM(String JSXM) {
        this.JSXM = JSXM;
    }

    public String getJSGH() {
        return JSGH;
    }

    public void setJSGH(String JSGH) {
        this.JSGH = JSGH;
    }

    public String getSKJSMC() {
        return SKJSMC;
    }

    public void setSKJSMC(String SKJSMC) {
        this.SKJSMC = SKJSMC;
    }

    public String getSKJSDM() {
        return SKJSDM;
    }

    public void setSKJSDM(String SKJSDM) {
        this.SKJSDM = SKJSDM;
    }
}
