package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;
/**
 * @ClassName: IUser
 * @Description: 用户部分接口类，并使在该类中用注解的功能实现了自己的接口
 * @Author Stefan
 * @Date 2017/10/8
 */
@Mapper
public interface IUser {
    /**
     *  查询待注册用户名是否已存在
     * @param username  客户端传递过来的待注册用户名
     * @return  查询成功返回User对象，若未查询到有该对象，则返回为空
     */
    // 查询数据库查看该用户名是否已存在
    @Select("select `user_name` from mi_user where `user_name` = #{username}")
    // 如果查到有对象，使传递过来的参数和数据库字段匹配
    @Results({
            @Result(id=true,property="id",column="user_id"),
            @Result(property="username", column="user_name"),
    })
    User searchUnique(@Param("username") String username);

    /**
     *  实现注册的用户信息插入到数据库
     * @param user 客户端传递过来的待注册用户对象
     */
    // 插入用户注册信息到数据库
    @Insert("insert into mi_user (`user_name`, `user_login_pwd`) values(#{user.username}, #{user.loginPwd})")
    void register(@Param("user") User user);

    /**
     *  查询数据库查看该登陆用户名和密码是否匹配
     * @param user
     * @return 查询成功返回User对象，若未查询到有该对象，则返回为空
     */
    @Select("select * from mi_user where `user_name` = #{user.username} and `user_login_pwd` = #{user.loginPwd}")
    @Results({
            @Result(id=true, property="id", column="user_id"),
            @Result(property="username", column="user_name"),
            @Result(property="loginPwd", column="user_login_pwd"),
            @Result(property="headUrl", column="user_head_url"),
            @Result(property="nickname", column="user_nickname"),
            @Result(property="integral", column="user_integral"),
    })
    User loginVerification(@Param("user") User user);

	/**
	 * 更新用户昵称
	 * @param newNickname
	 * @param userID
	 * @return
	 */
	@Select("update mi_user set `user_nickname` = #{newNickname} where `user_id` = #{userID}")
    User updateNickname(@Param("newNickname") String newNickname, @Param("userID") String userID);
}
