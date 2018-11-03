package utils;

import pojo.BaseUser;
/**
 *  用户工具类
 * */
public class UserUtil {

    /**
     *  校验用户名
     * */
    public static BaseUser checkUser(BaseUser baseUser, BaseUser userByXGH) {
        if (userByXGH == null){
            return null; //表示用户不存在
        }
        String password = baseUser.getPassword();
        String sfz = userByXGH.getSFZ();
        userByXGH.setPassword( sfz.substring(sfz.length() - 6, sfz.length() ));

        if(userByXGH.getPassword().equals(password)) {
            userByXGH.setSFZ("");
            return userByXGH;
        }
        return  null;
    }
}
