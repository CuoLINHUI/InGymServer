package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.MomentItem;
import pojo.ResponseObject;
import service.MomentsService;

import java.util.List;

/**
 * @ClassName: MomentController
 * @Description: 用户动态部分控制层，调用MomentService层，为客户端返回数据（对外提供用户数据）
 * @Author Stefan
 * @Date 2017/12/1 15:02
 */
@Controller
@RequestMapping(path = "/community")
public class MomentsController {
    @Autowired
    private MomentsService momentsService;

    @RequestMapping(path = "/moments")
    @ResponseBody
    public ResponseObject<List<MomentItem>> getMoments(@RequestParam("page") int page, @RequestParam("size") int size){
        List<MomentItem> momentItemList = momentsService.getMoments(page, size);
        return new ResponseObject<List<MomentItem>>("ok", 1, momentItemList);
    }

}
