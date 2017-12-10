package service;

import dao.IFoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Foods;

import java.util.List;

/**
 * @ClassName: FoodsService
 * @Description:  搜索食物部分的服务类，调用IFoods层实现方法，为FoodsController层提供返回值
 * @Author Stefan
 * @Date 2017/11/23 11:05
 */
@Service
public class FoodsService {
    @Autowired
    private IFoods foodsDao;

    public List<Foods> searchFoods(int page, int size, String keyword) {
        return foodsDao.searchFoods((page - 1) * size, page * size, keyword);
    }

}
