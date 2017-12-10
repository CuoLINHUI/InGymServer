package dao;

import org.apache.ibatis.annotations.*;
import pojo.*;

import java.util.List;

/**
 * @ClassName: IMoments
 * @Description:  用户动态部分接口类，并使在该类中用注解的功能实现了自己的接口
 * @Author Stefan
 * @Date 2017/12/1 15:15
 */
@Mapper
public interface IMoments {
	/**
	 * 使用@One注解来实现嵌套select语句，加载一对一关联查询数据。
	 * MyBatis提供了@Many注解，用来实现嵌套Select语句加载一对多关联查询。
	 */

	/**
	 * 查询点赞表（根据动态ID查询出该动态对应的所有点赞者用户名）
	 *
	 */
	@Select("select * from com_moment_like where `moment_id` = #{momentID}")
	@Results({
			@Result(id=true, property="id", column="like_id"),
			@Result(property="user", column="user_id", many = @Many(select = "dao.IMoments.getUserByMomentId")),
	})
	List<LikeItem> whoLikes(String momentID);

	/**
	 * 查询评论表（根据动态ID查询出该动态对应的所有的评论）
	 */
	@Select("select * from com_moment_comment where `moment_id` = #{momentID}")
	@Results({
			@Result(id=true, property="id", column="comment_id"),
			@Result(property="content", column="comment_content"),
			@Result(property="user", column="comment_user_id", many = @Many(select = "dao.IMoments.getUserByMomentId")),
			@Result(property="toReplyUser", column="to_reply_user_id", many = @Many(select = "dao.IMoments.getUserByMomentId")),
	})
	List<CommentItem> whichComments(String momentID);

	/**
	 * 查询图片表（根据动态ID查询出该动态对应的所有的图片）
	 */
	@Select("select * from com_moment_photoinfo where `moment_id` = #{momentID}")
	@Results({
//			@Result(id=true, property="id", column="photo_id"),
			@Result(property="url", column="photo_url"),
			@Result(property="w", column="photo_width"),
			@Result(property="h", column="photo_height"),
	})
	List<PhotoInfo> momentPhotos(String momentID);

	/**
	 * 一对多关联查询。
	 * 查询用户动态表（根据客户端请求的数据条数返回对应数目的用户动态数据）
	 */
	@Select("select * from com_moment limit #{start}, #{offset}")
	@Results({
			@Result(id=true, property="id", column="moment_id"),
			@Result(property="content", column="moment_content"),
			@Result(property="createTime", column="moment_time"),
	})
	List<MomentItem> loadMoments(@Param("start") int start, @Param("offset") int offset);

	@Select("select * from mi_user where `user_id`=#{momentID}")
	@Results({
			@Result(id=true, property="id", column="user_id"),
			@Result(property="nickname", column="user_nickname"),
			@Result(property="headUrl", column="user_head_url"),
	})
	User getUserByMomentId(@Param("momentID")String momentID);
}
