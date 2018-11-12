package pojo;

public class User {
    //学工号
    private String XGH;
    private String XM;

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    //身份证
    private String SFZ;
    //密码（截取身份证后六位）
    private String password;

    public String getXGH() {
        return XGH;
    }

    public void setXGH(String XGH) {
        this.XGH = XGH;
    }

    public String getSFZ() {
        return SFZ;
    }

    public void setSFZ(String SFZ) {
        this.SFZ = SFZ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
