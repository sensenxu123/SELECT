package pojo;

import java.util.List;

public class BookUser {
    private String WID;                     //ID
    private String SFRZH;                   //身份认证号
    private String DZXM;                    //姓名
    private String XBDM;                    //性别代码
    private String DWMC;                    //院系名称
    private String DZLXDM;                  //
    private String BZRQ;                    //办证日期
    private String YJCS;                    //阅借次数
    private String LJCC;                    //历史借阅次数
    private String QKJE;                    //欠款
    private String ZJZT;                    //在藉状态
    private String SFID;                    //身份ID


    @Override
    public String toString() {
        return "BookUser{" +
                "WID='" + WID + '\'' +
                ", SFRZH='" + SFRZH + '\'' +
                ", DZXM='" + DZXM + '\'' +
                ", XBDM='" + XBDM + '\'' +
                ", DWMC='" + DWMC + '\'' +
                ", DZLXDM='" + DZLXDM + '\'' +
                ", BZRQ='" + BZRQ + '\'' +
                ", YJCS='" + YJCS + '\'' +
                ", LJCC='" + LJCC + '\'' +
                ", QKJE='" + QKJE + '\'' +
                ", ZJZT='" + ZJZT + '\'' +
                ", SFID='" + SFID + '\'' +
                '}';
    }

    public String getWID() {
        return WID;
    }

    public void setWID(String WID) {
        this.WID = WID;
    }

    public String getSFRZH() {
        return SFRZH;
    }

    public void setSFRZH(String SFRZH) {
        this.SFRZH = SFRZH;
    }

    public String getDZXM() {
        return DZXM;
    }

    public void setDZXM(String DZXM) {
        this.DZXM = DZXM;
    }

    public String getXBDM() {
        return XBDM;
    }

    public void setXBDM(String XBDM) {
        this.XBDM = XBDM;
    }

    public String getDWMC() {
        return DWMC;
    }

    public void setDWMC(String DWMC) {
        this.DWMC = DWMC;
    }

    public String getDZLXDM() {
        return DZLXDM;
    }

    public void setDZLXDM(String DZLXDM) {
        this.DZLXDM = DZLXDM;
    }

    public String getBZRQ() {
        return BZRQ;
    }

    public void setBZRQ(String BZRQ) {
        this.BZRQ = BZRQ;
    }

    public String getYJCS() {
        return YJCS;
    }

    public void setYJCS(String YJCS) {
        this.YJCS = YJCS;
    }

    public String getLJCC() {
        return LJCC;
    }

    public void setLJCC(String LJCC) {
        this.LJCC = LJCC;
    }

    public String getQKJE() {
        return QKJE;
    }

    public void setQKJE(String QKJE) {
        this.QKJE = QKJE;
    }

    public String getZJZT() {
        return ZJZT;
    }

    public void setZJZT(String ZJZT) {
        this.ZJZT = ZJZT;
    }

    public String getSFID() {
        return SFID;
    }

    public void setSFID(String SFID) {
        this.SFID = SFID;
    }
}
