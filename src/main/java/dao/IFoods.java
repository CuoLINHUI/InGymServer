package dao;

import org.apache.ibatis.annotations.*;
import pojo.Foods;

import java.util.List;

/**
 * @ClassName: IFoods
 * @Description:  搜索食物部分接口类，并使在该类中用注解的功能实现了自己的接口
 * @Author Stefan
 * @Date 2017/11/23 11:07
 */
@Mapper
public interface IFoods {

    @Select("select * from hi_food where food_name LIKE concat('%',#{keyword},'%') limit #{start}, #{offset}")
    @Results({
            @Result(id=true, property="id", column="food_id"),
            @Result(property="food_name", column="food_name"),
            @Result(property="food_pic", column="food_pic"),
            @Result(property="food_calorie", column="food_calorie"),
            @Result(property="food_weight", column="food_weight"),
            @Result(property="food_protein", column="food_protein"),
            @Result(property="food_carbohydrate", column="food_carbohydrate"),
            @Result(property="food_fat", column="food_fat"),
            @Result(property="food_cellulose", column="food_cellulose"),
            @Result(property="food_detail", column="food_detail"),
            @Result(property="food_recommended_types", column="food_recommended_types"),
            @Result(property="food_cuisine", column="food_cuisine"),
            @Result(property="food_cooking_detail", column="food_cooking_detail"),
    })
    List<Foods> searchFoods(@Param("start") int start, @Param("offset") int offset, @Param("keyword") String keyword);

}
