package test;

import org.junit.Assert;
import org.junit.Test;
import pojo.Subject;
import utils.SubjectUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *   测试课表工具类
 *
 */
public class SubjectUtilTest {

    @Test
    public void disposeZZTForEmptyTest() {

        String s = SubjectUtil.disposeZZT("");

        assertEquals("",s);

    }


    @Test
    public void disposeZZTQTest() {

        String s = SubjectUtil.disposeZZT("11111111111100000000");

        assertEquals("[1-12]全",s);

    }

    @Test
    public void disposeZZTDTest() {

        String s = SubjectUtil.disposeZZT("10101010101010000000");

        assertEquals("[1-13]单",s);

    }

    @Test
    public void disposeZZTSTest() {

        String s = SubjectUtil.disposeZZT("00000000010101010100");

        assertEquals("[10-18]双",s);

    }

    @Test
    public void disposeZZTFTest() {

        String s = SubjectUtil.disposeZZT("000011010010101010100");

        assertEquals("[5-19]杂",s);

    }

    @Test
    public void nodupTest() {

        //创建list
        List<Subject> subjects = null;
        //
        List<Subject> nodup = SubjectUtil.nodup(subjects);
        Assert.assertNull(nodup);

        //创建list
        subjects = new ArrayList<>();
        subjects.add(new Subject("1","1","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("1","1","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("2","1","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("2","1","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("1","2","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("1","2","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("1","1","2","2","1","","","1","","1","1"));
        subjects.add(new Subject("1","1","2","2","1","","","1","","1","1"));
        subjects.add(new Subject("1","1","1","1","2","","","1","","1","1"));
        subjects.add(new Subject("1","1","1","1","2","","","1","","1","1"));
        subjects.add(new Subject("1","1","1","1","1","","","2","","1","1"));
        subjects.add(new Subject("1","1","1","1","1","","","2","","1","1"));
        subjects.add(new Subject("1","1","1","1","1","","","1","","2","1"));
        subjects.add(new Subject("1","1","1","1","1","","","1","","2","1"));
        //
        List<Subject> nodup1 = SubjectUtil.nodup(subjects);

    }


    @Test
    public void testRepate() {

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("1","1","1","1","1","","","1","","1","1"));
        subjects.add(new Subject("2","1","1","1","1","","","1","","1","1"));

        Subject subject = new Subject("2", "1", "1", "1", "1", "", "", "1", "", "1", "1");
        int repeat = SubjectUtil.repeat(subjects, subject);
        Assert.assertEquals(1,repeat);

        subject = new Subject("3", "1", "1", "1", "1", "", "", "1", "", "1", "1");
        repeat = SubjectUtil.repeat(subjects, subject);
        Assert.assertEquals(-1,repeat);
    }

}
