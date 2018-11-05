package pojo;

public class CurrentBorrow {
    /*
     * 一个用户所借的一本书籍信息
     */

    private String TSTM;            //图书条码
    private String TSMC;            //图书名称
    private String DZTM;            //学号
    private String SFRZH;           //身份认证号
    private String JSRQ;            //结束日期
    private String YHRQ;            //应还日期
    private String XJBS;            //续借次数
    private String CLRQ;            //图书类型
    private String XJRQ;            //续借日期
    private String DZXM;            //姓名
    private String SSH;             //ssh

    public String getTSTM() {
        return TSTM;
    }

    public void setTSTM(String TSTM) {
        this.TSTM = TSTM;
    }

    public String getTSMC() {
        return TSMC;
    }

    public void setTSMC(String TSMC) {
        this.TSMC = TSMC;
    }

    public String getDZTM() {
        return DZTM;
    }

    public void setDZTM(String DZTM) {
        this.DZTM = DZTM;
    }

    public String getSFRZH() {
        return SFRZH;
    }

    public void setSFRZH(String SFRZH) {
        this.SFRZH = SFRZH;
    }

    public String getJSRQ() {
        return JSRQ;
    }

    public void setJSRQ(String JSRQ) {
        this.JSRQ = JSRQ;
    }

    public String getYHRQ() {
        return YHRQ;
    }

    public void setYHRQ(String YHRQ) {
        this.YHRQ = YHRQ;
    }

    public String getXJBS() {
        return XJBS;
    }

    public void setXJBS(String XJBS) {
        this.XJBS = XJBS;
    }

    public String getCLRQ() {
        return CLRQ;
    }

    public void setCLRQ(String CLRQ) {
        this.CLRQ = CLRQ;
    }

    public String getDZXM() {
        return DZXM;
    }

    public void setDZXM(String DZXM) {
        this.DZXM = DZXM;
    }

    public String getSSH() {
        return SSH;
    }

    public void setSSH(String SSH) {
        this.SSH = SSH;
    }

    public String getXJRQ() {
        return XJRQ;
    }

    public void setXJRQ(String XJRQ) {
        this.XJRQ = XJRQ;
    }
}
