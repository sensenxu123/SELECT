package service;

import com.github.pagehelper.PageInfo;
import pojo.*;

import java.util.List;

public interface LibraryService {

    BookUser login(BookUser bookUser);

    PageInfo<CurrentBorrow> getCurrentBorrow(String SFRZH, Integer startNum);

    PageInfo<HistoryBorrow> getHistoryBorrow(String SFRZH, Integer startNum);

    List<Book> findBookStatus(String SSH);

    PageInfo<Book> findBookByName(String TM, Integer startNum);

    List<Book> findBookBySSH(String SSH);

    PageInfo<BooksRanking> topRanking(Integer startNum);

    PageInfo<BooksRanking> categoryRanking(String FLH, Integer startNum);

}
