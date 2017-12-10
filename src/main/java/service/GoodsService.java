package service;

import dao.IGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<Goods> loadGoods(int page , int size, int category) {
        return goodsDao.loadGoods((page - 1) * size, page * size, category);
    }

}
