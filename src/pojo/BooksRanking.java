package pojo;

public class BooksRanking {

    private String TM;              //图书名称
    private String YJCS;            //借阅次数
    private String SSH;
    private String CBSMC;           //出版社名称
    private String DYZZ;            //作者信息

    @Override
    public String toString() {
        return "BooksRanking{" +
                "TM='" + TM + '\'' +
                ", YJCS='" + YJCS + '\'' +
                ", SSH='" + SSH + '\'' +
                ", CBSMC='" + CBSMC + '\'' +
                ", DYZZ='" + DYZZ + '\'' +
                '}';
    }

    public String getTM() {
        return TM;
    }

    public void setTM(String TM) {
        this.TM = TM;
    }

    public String getYJCS() {
        return YJCS;
    }

    public void setYJCS(String YJCS) {
        this.YJCS = YJCS;
    }

    public String getSSH() {
        return SSH;
    }

    public void setSSH(String SSH) {
        this.SSH = SSH;
    }

    public String getCBSMC() {
        return CBSMC;
    }

    public void setCBSMC(String CBSMC) {
        this.CBSMC = CBSMC;
    }

    public String getDYZZ() {
        return DYZZ;
    }

    public void setDYZZ(String DYZZ) {
        this.DYZZ = DYZZ;
    }
}
