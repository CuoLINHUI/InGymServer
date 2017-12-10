package service;

import dao.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Article;
import java.util.List;

/**
 * @ClassName: ArticleService
 * @Description:  资讯部分的服务类，调用IArticle层实现方法，为ArticleController层提供返回值
 * @Author Stefan
 * @Date 2017/10/30 14:40
 */
@Service
public class ArticleService {
    @Autowired
    private IArticle articleDao;

    /**
     * 调用IArticle中的loadArticle()方法，查询下拉加载的最新数据
     * @param page
     * @param size
     * @return
     */
    public List<Article> loadArticle(int page, int size) {
        return articleDao.loadArticle((page - 1) * size, page * size);
    }
}
