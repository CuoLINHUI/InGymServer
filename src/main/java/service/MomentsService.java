package service;

import dao.IMoments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.List;

/**
 * @ClassName: MomentsService
 * @Description:  用户动态部分的服务类，调用IMoments层实现方法，为MomentsController层提供返回值
 * @Author Stefan
 * @Date 2017/12/1 15:13
 */
@Service
public class MomentsService {
    @Autowired
    private IMoments momentsDao;

    public List<MomentItem> getMoments(int page, int size){
        List<MomentItem> momentItems = momentsDao.loadMoments((page - 1) * size, size);
        for (MomentItem momentItem : momentItems) {
            // 获取动态ID
            String id = momentItem.getId();
            // 查询该动态发表的图片
            List<PhotoInfo> photoInfos = momentsDao.momentPhotos(id);
            // 查询该动态的点赞用户
            List<LikeItem> likeItems = momentsDao.whoLikes(id);
            // 查询该动态的评论信息
            List<CommentItem> commentItems = momentsDao.whichComments(id);

            User user = momentsDao.getUserByMomentId(id);
            momentItem.setFavorters(likeItems);
            momentItem.setPhotos(photoInfos);
            momentItem.setComments(commentItems);
            momentItem.setType("2");
            momentItem.setUser(user);
        }
        return momentItems;
    }
}
