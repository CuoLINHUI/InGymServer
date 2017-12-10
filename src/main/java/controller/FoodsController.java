package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Foods;
import pojo.ResponseObject;
import service.FoodsService;

import java.util.List;

/**
 * @ClassName: FoodsController
 * @Description: 搜索食物部分控制层，调用FoodsService层，为客户端返回数据（对外提供用户数据）
 * @Author Stefan
 * @Date 2017/11/23 10:59
 */
@Controller
@RequestMapping(path = "/index")
public class FoodsController {
    @Autowired
    private FoodsService foodsService;

    @ResponseBody
    @RequestMapping(path = "/hi_foods")
    public ResponseObject<Foods> search_foods(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("keyword")  String keyword) {

        ResponseObject result;

        List<Foods> foods = foodsService.searchFoods(page, size, keyword);

        if (foods != null) {
            result = new ResponseObject(1, foods);
        } else {
            result = new ResponseObject(0, "获取商品信息失败");
        }

        return result;
    }

}
