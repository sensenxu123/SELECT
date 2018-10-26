package pojo;

public class CardFlow {
    //学工号
    private String XGH;
    //姓名
    private String XM;

    public String getXGH() {
        return XGH;
    }

    public void setXGH(String XGH) {
        this.XGH = XGH;
    }

    @Override
    public String toString() {
        return "CardFlow{" +
                "XGH='" + XGH + '\'' +
                ", XM='" + XM + '\'' +
                '}';
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }
}
