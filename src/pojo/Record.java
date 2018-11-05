package pojo;

/**
 *消费明细pojo
 */
public class Record {
    //消费类型
    private String JYLX;
    //消费时间
    private String JYSJ;
    //地点
    private String SHMC;
    //消费金额
    private String JYE;

    public String getJYLX() {
        return JYLX;
    }

    public void setJYLX(String JYLX) {
        this.JYLX = JYLX;
    }

    public String getJYSJ() {
        return JYSJ;
    }

    public void setJYSJ(String JYSJ) {
        this.JYSJ = JYSJ;
    }

    public String getSHMC() {
        return SHMC;
    }

    public void setSHMC(String SHMC) {
        this.SHMC = SHMC;
    }

    public String getJYE() {
        return JYE;
    }

    public void setJYE(String JYE) {
        this.JYE = JYE;
    }

    @Override
    public String toString() {
        return "Record{" +
                "JYLX='" + JYLX + '\'' +
                ", JYSJ='" + JYSJ + '\'' +
                ", SHMC='" + SHMC + '\'' +
                ", JYE='" + JYE + '\'' +
                '}';
    }
}
