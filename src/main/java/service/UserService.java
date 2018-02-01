package service;

import dao.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

/**
 * @ClassName: UserService
 * @Description: 用户部分的服务类，调用IUser层实现方法，为UserController层提供返回值
 * @Author Stefan
 * @Date 2017/10/8
 */
@Service
public class UserService {
    @Autowired
    private IUser userDao;

    /**
     * 判断用户注册的用户名是否已存在
     * @param username
     * @return
     */
    public User searchUnique (String username) {
       return userDao.searchUnique(username);
    }

    /**
     * 向数据库插入用户注册信息
     * @param user
     */
    public void register(User user){
        userDao.register(user);
    }

    /**
     * 调用DAO层查询该用户名和密码是否存在且匹配
     * @param user
     * @return
     */
    public User loginVerification(User user) {
        return userDao.loginVerification(user);
    }

	/**
	 * 调用DAO层修改Nickname
	 * @param newNickname
	 * @return
	 */
    public User updateNickname(String newNickname, String userID) {
        return userDao.updateNickname(newNickname, userID);
    }

	/**
	 * 调用DAO层修改登陆密码
	 * @param user
	 */
	public void updatePassword(User user) {
		userDao.updatePassword(user);
	}

	/* 在service层就要写上面那样
	public void updatePassword(String id, String password) {
		userDao.updatePassword(id, password);
	}*/

	public void setPayment(User user) {
		userDao.setPayment(user);
	}

	/**
	 * 调用DAO层修改支付密码
	 * @param user
	 */
	public void updatePayment(User user) {
		userDao.setPayment(user);
	}

	/**
	 * 调用DAO层绑定手机号
	 * @param phoneNumber
	 * @param userID
	 */
	public void bindPhone(String phoneNumber, String userID) {
		userDao.bindPhone(phoneNumber, userID);
	}

	/**
	 * 调用DAO层修改积分
	 * @param user
	 */
	public void updateIntegral(User user) {
		userDao.updateIntegral(user);
	}

}
