package dao;

import org.apache.ibatis.annotations.Param;
import pojo.*;

import java.util.List;

public interface LibraryDao {
    BookUser getUserInfoBySFRZH(String SFRZH);

    List<CurrentBorrow> findCurrentBorrowBySFRZH(String SFRZH);

    List<HistoryBorrow> findHistoryBorrowBySFRZH(String SFRZH);

    List<Book> findOneBookBorrowStatus(String SSH);

    List<Book> findBookByName(@Param("origin") String origin, @Param("upper") String Upper, @Param("lower") String lowwer);

    List<Book> findBookBySSH(String SSH);

    List<BooksRanking> topRanking();

    List<BooksRanking> categoryRanking(@Param("FLH") String FLH);
}
