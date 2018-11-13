package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.LibraryService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})//加载spring配置文件
public class test {
    @Autowired
    private LibraryService libraryService;
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
