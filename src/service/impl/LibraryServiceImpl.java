package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.LibraryService;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryDao libraryDao;

    @Override
    public BookUser login(BookUser bookUser) {
        //通过学号获取该用户全部信息
        BookUser rightUser = libraryDao.getUserInfoBySFRZH(bookUser.getSFRZH());
        if (rightUser == null) {
            //用户不存在
            return null;
        }

        //获取身份证号后六位判断
        if (rightUser.getSFID() != null &&
                rightUser.getSFID().substring(rightUser.getSFID().length() - 6).equals(bookUser.getSFID())) {
            return rightUser;
        }

        return null;
    }

    @Override
    public List<CurrentBorrow> getCurrentBorrow(String SFRZH) {
        List<CurrentBorrow> list = libraryDao.findCurrentBorrowBySFRZH(SFRZH);
        return list;
    }

    @Override
    public List<HistoryBorrow> getHistoryBorrow(String SFRZH) {
        List<HistoryBorrow> list = libraryDao.findHistoryBorrowBySFRZH(SFRZH);
        return list;
    }

    @Override
    public PageInfo<Book> findBookStatus(String SSH,Integer startNum) {
        if (startNum == null)
            startNum = 1;
        PageHelper.startPage(startNum, 5);
        List<Book> list = libraryDao.findOneBookBorrowStatus(SSH);
        PageInfo<Book> info = new PageInfo<>(list, 3);

        return info;
    }

    @Override
    public PageInfo<Book> findBookByName(String TM, Integer startNum) {
        if (startNum == null)
            startNum = 1;
        //模糊查询 包括全部大写字符串 全部小写字符串
        String upper = TM.toUpperCase();
        String lower = TM.toLowerCase();
        PageHelper.startPage(startNum, 8);
        List<Book> bookByName = libraryDao.findBookByName(TM, upper, lower);
        PageInfo<Book> info = new PageInfo<>(bookByName, 5);
        return info;
    }

    @Override
    public List<Book> findBookBySSH(String SSH) {
        List<Book> list = libraryDao.findBookBySSH(SSH);
        return list;
    }

    @Override
    public PageInfo<BooksRanking> topRanking(Integer startNum) {
        if (startNum == null)
            startNum = 1;
        PageHelper.startPage(startNum, 8);
        List<BooksRanking> list = libraryDao.topRanking();
        PageInfo<BooksRanking> info = new PageInfo<>(list, 5);

        return info;
    }

    @Override
    public PageInfo<BooksRanking> categoryRanking(String FLH, Integer startNum) {
        if (startNum == null)
            startNum = 1;
        FLH = FLH.toUpperCase();
        PageHelper.startPage(startNum, 8);

        List<BooksRanking> list = libraryDao.categoryRanking(FLH);
        PageInfo<BooksRanking> info = new PageInfo<>(list, 5);

        return info;
    }
}
