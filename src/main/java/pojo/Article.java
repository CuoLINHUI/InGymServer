package pojo;

/**
 * @ClassName: Article
 * @Description:  用于资讯数据的实体类
 * @Author Stefan
 * @Date 2017/10/30 13:31
 */
public class Article {
    /**
     * 注意：服务端的实体类属性的命名一定要和客户端实体类的命名一致！！！不然会报错！
     */
    private String id;                      // 资讯ID
    private String title;                   // 资讯标题
    private String title_description;       // 标题描述
    private String pictureURL;              // 资讯条目图片（还是返回路径吧）
    private String detail;                  // 资讯详细信息（返回html格式再去解析）
    private int agree_number;               // 资讯获得同意次数
    private int comments_number;            // 资讯被评论次数
    private int browse_times;               // 资讯浏览次数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_description() {
        return title_description;
    }

    public void setTitle_description(String title_description) {
        this.title_description = title_description;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getComments_number() {
        return comments_number;
    }

    public void setComments_number(int comments_number) {
        this.comments_number = comments_number;
    }

    public int getAgree_number() {
        return agree_number;
    }

    public void setAgree_number(int agree_number) {
        this.agree_number = agree_number;
    }

    public int getBrowse_times() {
        return browse_times;
    }

    public void setBrowse_times(int browse_times) {
        this.browse_times = browse_times;
    }

}
