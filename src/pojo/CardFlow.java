package pojo;

import java.util.Date;

public class CardFlow {
    //学工号
    private String XGH;
    //姓名
    private String XM;
    //消费时间
    private String jYSJ;
    //余额
    private String YE;

    public String getXGH() {
        return XGH;
    }

    public void setXGH(String XGH) {
        this.XGH = XGH;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }


    public String getjYSJ() {
        return jYSJ;
    }

    public void setjYSJ(String jYSJ) {
        this.jYSJ = jYSJ;
    }

    public String getYE() {
        return YE;
    }

    public void setYE(String YE) {
        this.YE = YE;
    }

    @Override
    public String toString() {
        return "CardFlow{" +
                "XGH='" + XGH + '\'' +
                ", XM='" + XM + '\'' +
                ", jYSJ='" + jYSJ + '\'' +
                ", YE='" + YE + '\'' +
                '}';
    }
}
