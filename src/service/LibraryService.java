package service;

import com.github.pagehelper.PageInfo;
import pojo.*;

import java.util.List;

public interface LibraryService {

    BookUser login(BookUser bookUser);

    List<CurrentBorrow> getCurrentBorrow(String SFRZH);

    List<HistoryBorrow> getHistoryBorrow(String SFRZH);

    List<Book> findBookStatus(String SSH);

    PageInfo<Book> findBookByName(String TM, Integer startNum);

    List<Book> findBookBySSH(String SSH);

    List<BooksRanking> topRanking();

    List<BooksRanking> categoryRanking(String FLH);

}
