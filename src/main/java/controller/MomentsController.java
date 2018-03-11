package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.MomentItem;
import pojo.PhotoInfo;
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

	/**
     * 获取数据库中的动态数据
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(path = "/moments")
    @ResponseBody
    public ResponseObject<List<MomentItem>> getMoments(@RequestParam("page") int page, @RequestParam("size") int size){
        List<MomentItem> momentItemList = momentsService.getMoments(page, size);
        for (int i = 0; i < momentItemList.size(); i++)
            System.out.print("momentItemList:" + momentItemList.get(i).toString());
        return new ResponseObject<List<MomentItem>>("ok", 1, momentItemList);
    }

	/**
     * 上传moment content到数据库
     * @param momentItem
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/upload_moments")
    public ResponseObject<String> uploadMoments(@RequestBody MomentItem momentItem) {
        String momentId = momentsService.uploadMoments(momentItem);
        // 返回moment的id
        return new ResponseObject<String>("动态发送成功！", 1, momentId);
    }

    @ResponseBody
    @RequestMapping(path = "/upload_pic")
    public ResponseObject<String> uploadMomentsPic(@RequestBody PhotoInfo photoInfo) {
        momentsService.uploadMomentsPic(photoInfo);

        return new ResponseObject<String>("动态图片发送成功！", 1);
    }

}
