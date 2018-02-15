package service;

import dao.IMoments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.Comparator;
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
        momentItems.sort(new Comparator<MomentItem>() {
            @Override
            public int compare(MomentItem o1, MomentItem o2) {
                return -o1.getId().compareTo(o2.getId());
            }
        });
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

	/**
     * 调用DAO层插入动态内容
     * @param momentItem
     * @return 返回插入成功后，该条动态I的D
     */
    public String uploadMoments(MomentItem momentItem) {
        momentsDao.uploadMoments(momentItem);
        return momentItem.getId();
    }

    public void uploadMomentsPic(PhotoInfo photoInfo) {
        momentsDao.uploadMomentsPic(photoInfo);
    }

}
