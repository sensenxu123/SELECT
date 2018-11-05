package test;

import static org.junit.Assert.*;
import org.junit.Test;

import utils.SubjectUtil;

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

}
