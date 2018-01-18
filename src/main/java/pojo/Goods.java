package pojo;

/**
 * @ClassName: Goods
 * @Description: 用于装备商品数据的实体类
 * @Author Stefan
 * @Date 2017/11/16 13:40
 */
public class Goods {
    /**
     * 注意：服务端的实体类属性的命名一定要和客户端实体类的命名一致！！！不然会报错！
     */

    private String id;                      // 商品ID
    private String category_id;             // 商品分类ID
    private String title;                   // 商品标题
    private String sort_title;              // 标题描述
    private String imageURL;                // 条目展示图片路径
    private String bigPicURL;               // 商品详情大图展示
    private String value;                   // 商品原价（价值）
    private String price;                   // 商品现价（价格）
    private String payments;                // 付款人数（商品销量）
    private String stock;                   // 商品库存量
    private String details;                 // 商品详情
    private String integral;                // 商品所需的积分

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSort_title() {
        return sort_title;
    }

    public void setSort_title(String sort_title) {
        this.sort_title = sort_title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getBigPicURL() {
        return bigPicURL;
    }

    public void setBigPicURL(String bigPicURL) {
        this.bigPicURL = bigPicURL;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }
}
