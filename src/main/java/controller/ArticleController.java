package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Article;
import pojo.ResponseObject;
import service.ArticleService;

import java.util.List;

/**
 * @ClassName: ArticleController
 * @Description:  资讯部分控制层，调用ArticleService层，为客户端返回数据（对外提供用户数据）
 * @Author Stefan
 * @Date 2017/10/30 14:38
 */
@Controller
@RequestMapping(path = "/index")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(path = "/hi_article")
    @ResponseBody
    public ResponseObject<Article> hi_article(@RequestParam("page") int page, @RequestParam("size") int size) {
        /**
         * 获取客户端传递过来的请求数据
         */
        ResponseObject result;
//        int page = object.getPage();    // 获取请求页码
//        int size = object.getSize();    // 获取请求数据条数

        List<Article> articles = articleService.loadArticle(page, size);

        if (articles != null) {
            result = new ResponseObject(1, articles);
            result.setPage(page);
            result.setSize(size);
        } else {
            result = new ResponseObject(0, "获取资讯信息失败");
        }

        return result;
    }

}
