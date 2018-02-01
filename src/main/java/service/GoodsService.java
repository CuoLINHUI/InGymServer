package service;

import dao.IGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Collections;
import pojo.Goods;

import java.util.List;

/**
 * @ClassName: GoodsService
 * @Description:  装备商品部分的服务类，调用IGoods层实现方法，为GoodsController层提供返回值
 * @Author Stefan
 * @Date 2017/11/16 14:08
 */
@Service
public class GoodsService {
    @Autowired
    private IGoods goodsDao;

	/**
     * 加载商品数据
     * @param page
     * @param size
     * @param category
     * @return
     */
    public List<Goods> loadGoods(int page , int size, int category) {
        return goodsDao.loadGoods((page - 1) * size, page * size, category);
    }

	/**
     * 商品收藏
     * @param userID
     * @param goodsID
     */
    public void goodsCollection(String userID, String goodsID) {
        goodsDao.goodsCollection(userID, goodsID);
    }

	/**
     * 取消商品收藏
     * @param userID
     * @param goodsID
     */
    public void collectionCancel(String userID, String goodsID) {
        goodsDao.collectionCancel(userID, goodsID);
    }

    public List<Collections> loadCollections(int page, int size) {
        List<Collections> goodsItems = goodsDao.loadCollections((page - 1) * size, page * size);
//        for (Goods goodsItem : goodsItems) {
//            // 获取商品ID
//           String goodsID = goodsItem.getId();
//            Goods goods = goodsDao.findGoodsById(goodsID);
//        }
        return goodsItems;
    }

    /**
     * 加载商品数据
     * @param page
     * @param size
     * @return
     */
    public List<Goods> shoppingMall(int page , int size) {
        return goodsDao.shoppingMall((page - 1) * size, page * size);
    }

}
