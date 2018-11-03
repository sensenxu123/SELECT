package pojo;

/**
 *  用于封装从  CARDINFO 中查询出来的  信息，
 *
 * */
public  class BaseUser {

    private String XGH;  //学工号
    private String SFMC; //身份名称
    private String SFZ;  //身份证
    private String password;    //密码（截取身份证后六位）
    private String XM;

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSFZ() {
        return SFZ;
    }

    public void setSFZ(String SFZ) {
        this.SFZ = SFZ;
    }

    public String getXGH() {
        return XGH;
    }

    public void setXGH(String XGH) {
        this.XGH = XGH;
    }

    public String getSFMC() {
        return SFMC;
    }

    public void setSFMC(String SFMC) {
        this.SFMC = SFMC;
    }
}
