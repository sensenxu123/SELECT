package test;

import org.apache.http.HttpRequest;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {


    @Autowired

    private HttpServletRequest request;


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
        try{
            System.out.println(request.getAttribute("ss"));
        }catch(Exception e){
            System.out.println("asd");
        }




    }

}
