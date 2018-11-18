package service;

import com.github.pagehelper.PageInfo;
import pojo.*;

import java.util.List;

public interface LibraryService {

    BookUser login(BookUser bookUser);

    List<CurrentBorrow> getCurrentBorrow(String SFRZH);

    List<HistoryBorrow> getHistoryBorrow(String SFRZH);

    PageInfo<Book> findBookStatus(String SSH,Integer startNum);

    PageInfo<Book> findBookByName(String TM, Integer startNum);

    List<Book> findBookBySSH(String SSH);

    PageInfo<BooksRanking> topRanking(Integer startNum);

    PageInfo<BooksRanking> categoryRanking(String FLH, Integer startNum);

}
