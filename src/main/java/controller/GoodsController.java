package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Collections;
import pojo.Goods;
import pojo.ResponseObject;
import service.GoodsService;

import java.util.List;

/**
 * @ClassName: GoodsController
 * @Description:  装备商品部分控制层，调用GoodsService层，为客户端返回数据（对外提供用户数据）
 * @Author Stefan
 * @Date 2017/11/16 13:57
 */
@Controller
@RequestMapping(path = "/community")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

	/**
     * 查询所有装备商品
     * @param page  页码
     * @param size  请求数据量大小
     * @param category 装备商品分类
     * @return 返回查询结果
     */
    @ResponseBody
    @RequestMapping(path = "/equipment_goods")
    public ResponseObject<Goods> equipment_goods(@RequestParam("page") int page,
        @RequestParam("size") int size ,@RequestParam("category") int category) {
        /**
         * 获取客户端传递过来的请求数据
         */
        ResponseObject result;
        List<Goods> goods = goodsService.loadGoods(page, size, category);
        if (goods != null) {
            result = new ResponseObject(1, goods);
            result.setPage(page);
            result.setSize(size);
        } else {
            result = new ResponseObject(0, "获取商品信息失败");
        }
        return result;
    }

	/**
     * 商品收藏
     * @param userID
     * @param goodsID
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/collection_goods")
    public ResponseObject<String> collectionSave(@RequestParam("user_id") String userID ,@RequestParam("goods_id") String goodsID) {
        if(userID != null && goodsID != null) {
            goodsService.goodsCollection(userID, goodsID);
            return  new ResponseObject<String>("收藏成功", 1);
        }
        return new ResponseObject<String>("收藏失败", 0);
    }

	/**
     * 取消商品收藏
     * @param userID
     * @param goodsID
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/collection_cancel")
    public ResponseObject<String> collectionCancel(@RequestParam("user_id") String userID ,@RequestParam("goods_id") String goodsID) {

        if(userID != null && goodsID != null) {
            goodsService.collectionCancel(userID, goodsID);
            return  new ResponseObject<String>("取消收藏成功", 1);
        }
        return new ResponseObject<String>("取消收藏失败", 0);
    }

    @ResponseBody
    @RequestMapping(path = "/load_collection")
    public ResponseObject<Collections> loadCollection(@RequestParam("page") int page ,@RequestParam("size") int size) {
        ResponseObject result;

        List<Collections> collections = goodsService.loadCollections(page, size);

        if (collections != null) {
            result = new ResponseObject(1, collections);
        } else {
            result = new ResponseObject(0, "获取收藏信息失败");
        }
        return result;
    }

    /**
     * 查询所有装备商品
     * @param page  页码
     * @param size  请求数据量大小
     * @return 返回查询结果
     */
    @ResponseBody
    @RequestMapping(path = "/shopping_mall")
    public ResponseObject<Goods> shoppingMall(@RequestParam("page") int page, @RequestParam("size") int size ) {
        /**
         * 获取客户端传递过来的请求数据
         */
        ResponseObject result;
        List<Goods> goods = goodsService.shoppingMall(page, size);
        if (goods != null) {
            result = new ResponseObject(1, goods);
            result.setPage(page);
            result.setSize(size);
        } else {
            result = new ResponseObject(0, "获取商品信息失败！");
        }
        return result;
    }

}
