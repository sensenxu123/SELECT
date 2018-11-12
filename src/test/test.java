package test;

import org.junit.Test;
import utils.HttpClientUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    @Test
    public void test(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
       String JZRQ= sdf.format(date);
        System.out.println(JZRQ);


    }
    @Test
    public  void test1(){
        String cellphone="340111199809152011";
        String pwd = cellphone.substring(cellphone.length() - 6);
        System.out.println(pwd);
    }
    @Test
    public  void test2(){
        String YE="99";
        float pwd = Integer.parseInt(YE)/100.00f;
        System.out.println(pwd+"");
    }

}
