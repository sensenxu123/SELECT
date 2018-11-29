package controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.*;
import service.LibraryService;
import utils.HttpClientUtil;
import utils.JsonUtils;
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
    @RequestMapping(value = "/login", produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String login(BookUser bookUser,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            BookUser user = libraryService.login(bookUser);
            if (user == null) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("用户名或密码不正确")) + ")";
            }
            return  callback + "(" + JsonUtils.objectToJson(ResultUtil.success("登陆成功",user)) + ")";
        }
        return null;
    }

    /**
     * 当前借阅情况
     *
     * @param SFRZH
     * @return
     */
    @RequestMapping(value = "/currentborrow/{XH}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String currentBorrow(@PathVariable("XH") String SFRZH,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            List<CurrentBorrow> list = libraryService.getCurrentBorrow(SFRZH);
            if (list.size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("没有正在看的书呢,快去找本看看吧!")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("没有正在看的书呢,快去找本看看吧!")) + ")";
    }

    /**
     * 历史借阅情况
     *
     * @param SFRZH
     * @return
     */
    @RequestMapping(value = "/historyborrow/{XH}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String historyBorrow(@PathVariable("XH") String SFRZH,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            List<HistoryBorrow> list = libraryService.getHistoryBorrow(SFRZH);
            if (list.size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("找不到借过的书?!")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("找不到借过的书?!")) + ")";
    }

    /**
     * 查看某类书的借阅情况
     *
     * @param SSH
     * @return
     */
    @RequestMapping(value = "/findBookStatus/{page}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String findBookStatus(@PathVariable("page") Integer page, @RequestParam("SSH") String SSH, String callback) {
        if (StringUtils.isNotBlank(callback)) {
            PageInfo<Book> list = libraryService.findBookStatus(SSH, page);
            if (list.getList().size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("书本掉到代码池里去了...")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("书本掉到代码池里去了...")) + ")";
    }

    /**
     * 图书姓名模糊查询
     *
     * @param TM
     * @return
     */
    @RequestMapping(value = "/findBookByName/{TM}/{page}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String findBookByName(@PathVariable("TM") String TM,@PathVariable(value = "page") Integer page,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            PageInfo<Book> list = libraryService.findBookByName(TM, page);
            if (list.getList().size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("找不到想要的书...")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("找不到想要的书...")) + ")";
    }

    /**
     * 通过SSH精准查询书籍
     *
     * @param SSH
     * @return
     */
    @RequestMapping(value = "/findBookBySSH", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String findBookBySSH(@RequestParam("SSH") String SSH,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            List<Book> list = libraryService.findBookBySSH(SSH);
            if (list.size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("找不到想要的书...")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("找不到想要的书...")) + ")";
    }

    /**
     * 热门排行
     *
     * @return
     */
    @RequestMapping(value = "/topRanking/{page}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String topRanking(@PathVariable(value = "page") Integer page,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            PageInfo<BooksRanking> list = libraryService.topRanking(page);
            if (list.getList().size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("查询失败了...")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("查询失败了...")) + ")";
    }

    /**
     * 按类排行榜
     *
     * @param FLH
     * @return
     */
    @RequestMapping(value = "/categoryRanking/{FLH}/{page}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String categoryRanking(@PathVariable("FLH") String FLH, @PathVariable(value = "page") Integer page,String callback) {
        if (StringUtils.isNotBlank(callback)) {
            PageInfo<BooksRanking> list = libraryService.categoryRanking(FLH, page);
            if (list.getList().size() != 0) {
                return callback + "(" + JsonUtils.objectToJson(ResultUtil.success("查询成功", list)) + ")";
            }
            return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("查询失败了...")) + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("查询失败了...")) + ")";
    }


    /**
     * 图书简介
     * @param isbn
     * @param callback
     * @return
     */
    @RequestMapping(value = "/introduce/{isbn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String introduce(@PathVariable("isbn") String isbn, String callback) {
        if (StringUtils.isNotBlank(callback)) {
            String url = "http://222.195.118.20:8080/opac/ajax_douban.php?isbn=" + isbn.replaceAll("-", "");
            String result = HttpClientUtil.sendGet(url);

            return callback + "(" + result + ")";
        }
        return callback + "(" + JsonUtils.objectToJson(ResultUtil.error("查询失败了...")) + ")";
    }
}
