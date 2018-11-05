package controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.*;
import service.LibraryService;
import utils.ResultUtil;

import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    /**
     * 用户登陆
     *
     * @param bookUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(BookUser bookUser) {
        BookUser user = libraryService.login(bookUser);

        if (user == null) {
            return ResultUtil.error("用户名或密码不正确");
        }
        return ResultUtil.success("登陆成功", user);
    }

    /**
     * 当前借阅情况
     *
     * @param SFRZH
     * @return
     */
    @RequestMapping(value = "/borrow/{XH}/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Result currentBorrow(@PathVariable("XH") String SFRZH,@PathVariable(value = "page") Integer page) {
        PageInfo<CurrentBorrow> list = libraryService.getCurrentBorrow(SFRZH, page);

        if (list.getList().size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("没有正在看的书呢,快去找本看看吧!");
    }

    /**
     * 历史借阅情况
     *
     * @param SFRZH
     * @return
     */
    @RequestMapping(value = "/borrow/{XH}/{page}", method = RequestMethod.POST)
    @ResponseBody
    public Result historyBorrow(@PathVariable("XH") String SFRZH,@PathVariable(value = "page") Integer page) {
        PageInfo<HistoryBorrow> list = libraryService.getHistoryBorrow(SFRZH, page);
        if (list.getList().size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("找不到借过的书?!");
    }

    /**
     * 查看某类书的借阅情况
     *
     * @param SSH
     * @return
     */
    @RequestMapping(value = "/findBookStatus", method = RequestMethod.GET)
    @ResponseBody
    public Result findBookStatus(@RequestParam("SSH") String SSH) {
        List<Book> list = libraryService.findBookStatus(SSH);

        if (list.size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("书本掉到代码池里去了...");
    }

    /**
     * 图书姓名模糊查询
     *
     * @param TM
     * @return
     */
    @RequestMapping(value = "/findBookByName/{TM}/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Result findBookByName(@PathVariable("TM") String TM,@PathVariable(value = "page") Integer page) {
        PageInfo<Book> list = libraryService.findBookByName(TM, page);
        if (list.getList().size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("找不到想要的书...");
    }

    /**
     * 通过SSH精准查询书籍
     *
     * @param SSH
     * @return
     */
    @RequestMapping(value = "/findBookBySSH", method = RequestMethod.GET)
    @ResponseBody
    public Result findBookBySSH(@RequestParam("SSH") String SSH) {
        List<Book> list = libraryService.findBookBySSH(SSH);
        if (list.size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("找不到想要的书...");
    }

    /**
     * 热门排行
     *
     * @return
     */
    @RequestMapping(value = "/topRanking", method = RequestMethod.GET)
    @ResponseBody
    public Result topRanking() {
        List<BooksRanking> list = libraryService.topRanking();
        if (list.size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("查询失败了...");
    }

    /**
     * 按类排行榜
     *
     * @param FLH
     * @return
     */
    @RequestMapping(value = "/categoryRanking/{FLH}", method = RequestMethod.GET)
    @ResponseBody
    public Result categoryRanking(@PathVariable("FLH") String FLH) {
        List<BooksRanking> list = libraryService.categoryRanking(FLH);
        if (list.size() != 0) {
            return ResultUtil.success("查询成功", list);
        }
        return ResultUtil.error("查询失败了...");
    }
}
