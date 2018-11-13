package test;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.BooksRanking;
import service.LibraryService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class tempTest {
    @Autowired
    private LibraryService libraryService;

    @Test
    public void test() {
        PageInfo<BooksRanking> booksRankingPageInfo = libraryService.topRanking(1);
        System.out.println(booksRankingPageInfo.getList().size());

    }
}
