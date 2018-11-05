package pojo;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String WID;                     //ID
    private String TSTXM;                   //图书条形码
    private String DJH;                     //
    private String FLH;                     //分类号
    private String GCDM;                    //馆藏代码
    private String RDRQ;                    //阅读如期
    private String TSZTDM;                  //图书状态代码
    private String ISBN;                    //
    private String TM;                      //图书名
    private String CBSMC;                   //出版社名称
    private String CBRQ;                    //出版日期
    private String DYZZ;                    //作者
    private String GCDMC;                   //馆藏地名称
    private String JG;                      //
    private String SSH;                     //SSH
    private String WXLX;                    //文献类型

    private CurrentBorrow userInfo;         //借阅者信息

    @Override
    public String toString() {
        return "Book{" +
                "WID='" + WID + '\'' +
                ", TSTXM='" + TSTXM + '\'' +
                ", DJH='" + DJH + '\'' +
                ", FLH='" + FLH + '\'' +
                ", GCDM='" + GCDM + '\'' +
                ", RDRQ='" + RDRQ + '\'' +
                ", TSZTDM='" + TSZTDM + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", TM='" + TM + '\'' +
                ", CBSMC='" + CBSMC + '\'' +
                ", CBRQ='" + CBRQ + '\'' +
                ", DYZZ='" + DYZZ + '\'' +
                ", GCDMC='" + GCDMC + '\'' +
                ", JG='" + JG + '\'' +
                ", SSH='" + SSH + '\'' +
                ", WXLX='" + WXLX + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }

    public String getWID() {
        return WID;
    }

    public void setWID(String WID) {
        this.WID = WID;
    }

    public String getTSTXM() {
        return TSTXM;
    }

    public void setTSTXM(String TSTXM) {
        this.TSTXM = TSTXM;
    }

    public String getDJH() {
        return DJH;
    }

    public void setDJH(String DJH) {
        this.DJH = DJH;
    }

    public String getFLH() {
        return FLH;
    }

    public void setFLH(String FLH) {
        this.FLH = FLH;
    }

    public String getGCDM() {
        return GCDM;
    }

    public void setGCDM(String GCDM) {
        this.GCDM = GCDM;
    }

    public String getRDRQ() {
        return RDRQ;
    }

    public void setRDRQ(String RDRQ) {
        this.RDRQ = RDRQ;
    }

    public String getTSZTDM() {
        return TSZTDM;
    }

    public void setTSZTDM(String TSZTDM) {
        this.TSZTDM = TSZTDM;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTM() {
        return TM;
    }

    public void setTM(String TM) {
        this.TM = TM;
    }

    public String getCBSMC() {
        return CBSMC;
    }

    public void setCBSMC(String CBSMC) {
        this.CBSMC = CBSMC;
    }

    public String getCBRQ() {
        return CBRQ;
    }

    public void setCBRQ(String CBRQ) {
        this.CBRQ = CBRQ;
    }

    public String getDYZZ() {
        return DYZZ;
    }

    public void setDYZZ(String DYZZ) {
        this.DYZZ = DYZZ;
    }

    public String getGCDMC() {
        return GCDMC;
    }

    public void setGCDMC(String GCDMC) {
        this.GCDMC = GCDMC;
    }

    public String getJG() {
        return JG;
    }

    public void setJG(String JG) {
        this.JG = JG;
    }

    public String getSSH() {
        return SSH;
    }

    public void setSSH(String SSH) {
        this.SSH = SSH;
    }

    public String getWXLX() {
        return WXLX;
    }

    public void setWXLX(String WXLX) {
        this.WXLX = WXLX;
    }

    public CurrentBorrow getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(CurrentBorrow userInfo) {
        this.userInfo = userInfo;
    }
}
