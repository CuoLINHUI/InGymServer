package dao;

import org.apache.ibatis.annotations.*;
import pojo.Article;
import pojo.Collections;
import pojo.Goods;

import java.util.List;

/**
 * @ClassName: IGoods
 * @Description:  装备商品部分接口类，并使在该类中用注解的功能实现了自己的接口
 * @Author Stefan
 * @Date 2017/11/16 14:21
 */
@Mapper
public interface IGoods {
    /**
     * 根据传递的size大小，查询下拉加载的最新数据
     * @param start
     * @param offset
     * @return
     */
    @Select("select * from com_product where category_id = #{category} limit #{start}, #{offset}")
    @Results({
            @Result(id=true, property="id", column="product_id"),
            @Result(property="category_id", column="category_id"),
            @Result(property="title", column="product_title"),
            @Result(property="sort_title", column="product_sort_title"),
            @Result(property="imageURL", column="product_image"),
            @Result(property="bigPicURL", column="product_big_pic"),
            @Result(property="value", column="product_value"),
            @Result(property="price", column="product_price"),
            @Result(property="payments", column="product_payments"),
            @Result(property="stock", column="product_stock"),
            @Result(property="details", column="product_details"),
            @Result(property="integral", column="product_integral"),
    })
    List<Goods> loadGoods(@Param("start") int start, @Param("offset") int offset, @Param("category") int category);

	/**
     * 记录用户收藏的商品
     * @param userID 用户ID
     * @param goodsID 商品ID
     */
    @Insert("insert into com_collections (`user_id`, `collection_goods_id`) values(#{userID}, #{goodsID})")
    void goodsCollection(@Param("userID") String userID, @Param("goodsID") String goodsID);

    @Delete("delete from com_collections where `user_id` = #{userID} and `collection_goods_id` = #{goodsID}")
    void collectionCancel(@Param("userID") String userID, @Param("goodsID") String goodsID);

    @Select("select * from com_product where `product_id` = #{goodsID}")
    @Results({
            @Result(id=true, property="id", column="product_id"),
            @Result(property="category_id", column="category_id"),
            @Result(property="title", column="product_title"),
            @Result(property="sort_title", column="product_sort_title"),
            @Result(property="imageURL", column="product_image"),
            @Result(property="bigPicURL", column="product_big_pic"),
            @Result(property="value", column="product_value"),
            @Result(property="price", column="product_price"),
            @Result(property="payments", column="product_payments"),
            @Result(property="stock", column="product_stock"),
            @Result(property="details", column="product_details"),
            @Result(property="integral", column="product_integral"),
    })
    Goods findGoodsById(@Param("goodsID") String goodsID);

	/**
     * 查询用户收藏的商品信息（根据com_collections表中的被收藏的商品ID查询出该商品对应的所有信息）
     * @param start
     * @param offset
     * @return
     */
    @Select("select * from com_collections limit #{start}, #{offset}")
    @Results({
            @Result(id=true, property="collectionID", column="collection_id"),
            @Result(property="goods", column="collection_goods_id", many = @Many(select = "dao.IGoods.findGoodsById")),
    })
    List<Collections> loadCollections(@Param("start") int start, @Param("offset") int offset);
}
