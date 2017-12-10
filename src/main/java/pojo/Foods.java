package pojo;

/**
 * @ClassName: Foods
 * @Description:  用于封装食物数据的实体类
 * @Author Stefan
 * @Date 2017/11/23 10:50
 */
public class Foods {
    /**
     * 注意：服务端的实体类属性的命名一定要和客户端实体类的命名一致！！！不然会报错！
     */
    private String id;                          // 食物ID
    private String food_name;                   // 食物名称
    private String food_pic;                    // 食物条目路径
    private String food_calorie;                // 食物每100克的卡路里
    private String food_weight;                 // 食物质量
    private String food_protein;                // 食物每100克的蛋白质
    private String food_carbohydrate;           // 食物每100克的碳水化合物
    private String food_fat;                    // 食物每100克的脂肪
    private String food_cellulose;              // 食物每100克的纤维素
    private String food_detail;                 // 详情描述
    private String food_recommended_types;      // 推荐类型
    private String food_cuisine;                // 食物菜系
    private String food_cooking_detail;         // 食物烹饪方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_pic() {
        return food_pic;
    }

    public void setFood_pic(String food_pic) {
        this.food_pic = food_pic;
    }

    public String getFood_calorie() {
        return food_calorie;
    }

    public void setFood_calorie(String food_calorie) {
        this.food_calorie = food_calorie;
    }

    public String getFood_weight() {
        return food_weight;
    }

    public void setFood_weight(String food_weight) {
        this.food_weight = food_weight;
    }

    public String getFood_protein() {
        return food_protein;
    }

    public void setFood_protein(String food_protein) {
        this.food_protein = food_protein;
    }

    public String getFood_carbohydrate() {
        return food_carbohydrate;
    }

    public void setFood_carbohydrate(String food_carbohydrate) {
        this.food_carbohydrate = food_carbohydrate;
    }

    public String getFood_fat() {
        return food_fat;
    }

    public void setFood_fat(String food_fat) {
        this.food_fat = food_fat;
    }

    public String getFood_cellulose() {
        return food_cellulose;
    }

    public void setFood_cellulose(String food_cellulose) {
        this.food_cellulose = food_cellulose;
    }

    public String getFood_detail() {
        return food_detail;
    }

    public void setFood_detail(String food_detail) {
        this.food_detail = food_detail;
    }

    public String getFood_recommended_types() {
        return food_recommended_types;
    }

    public void setFood_recommended_types(String food_recommended_types) {
        this.food_recommended_types = food_recommended_types;
    }

    public String getFood_cuisine() {
        return food_cuisine;
    }

    public void setFood_cuisine(String food_cuisine) {
        this.food_cuisine = food_cuisine;
    }

    public String getFood_cooking_detail() {
        return food_cooking_detail;
    }

    public void setFood_cooking_detail(String food_cooking_detail) {
        this.food_cooking_detail = food_cooking_detail;
    }
}
