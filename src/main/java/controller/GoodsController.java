package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    @RequestMapping(path = "/equipment_goods")
    public ResponseObject<Goods> equipment_goods(@RequestParam("page") int page, @RequestParam("size") int size ,@RequestParam("category") int category) {
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

}
