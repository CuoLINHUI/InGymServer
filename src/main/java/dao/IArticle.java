package dao;

import org.apache.ibatis.annotations.*;
import pojo.Article;
import pojo.ResponseObject;

import java.util.List;

/**
 * @ClassName: IArticle
 * @Description:  资讯部分接口类，并使在该类中用注解的功能实现了自己的接口
 * @Author Stefan
 * @Date 2017/10/30 14:42
 */
@Mapper
public interface IArticle {

    /**
     * 根据传递的size大小，查询下拉加载的最新数据
     * @param start
     * @param offset
     * @return
     */
    @Select("select * from hi_article limit #{start}, #{offset}")
    @Results({
            @Result(id=true, property="id", column="article_id"),
            @Result(property="title", column="article_title"),
            @Result(property="title_description", column="article_title_description"),
            @Result(property="pictureURL", column="article_pic"),
            @Result(property="detail", column="article_detail"),
            @Result(property="agree_number", column="article_agree"),
            @Result(property="comments_number", column="article_comments"),
            @Result(property="browse_times", column="article_browse_times"),
    })
    List<Article> loadArticle(@Param("start") int start, @Param("offset") int offset);

}
