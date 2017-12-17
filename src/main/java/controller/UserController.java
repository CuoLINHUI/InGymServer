package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.ResponseObject;
import pojo.User;
import service.UserService;

/**
 * @ClassName: UserController
 * @Description: 用户部分控制层，调用UserService层，为客户端返回数据（对外提供用户数据）
 * @Author Stefan
 * @Date 2017/10/8
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *  接收用户注册请求，并进行相应的业务逻辑判断，最后响应客户端响应数据
     * @param user 响应参数
     * @return  返回数据给客户端
     * 注意：该方法的返回类型为String --> ResponseObject<String> --> 客户端接收部分的类型也要为String，不然会报错！！！
     */
    @RequestMapping(path = "/register")
    @ResponseBody
    public ResponseObject<String> register(@RequestBody User user){
//        System.out.println(user.toString());
        // 获取判断用户注册的用户名是否已存在方法的返回值
        User exist = userService.searchUnique(user.getUsername());
        // 如果返回值不为空则表示用户名已存在，不允许注册
        if (exist != null) {
            // 返回客户端出错信息
            return new ResponseObject<String>("用户名已存在！", 0);
        } else {
            // 调用方法，允许用户注册
            userService.register(user);
            return new ResponseObject<String>("注册成功! 请登陆。", 1);
        }
    }

    /**
     *  接收用户登陆请求，并进行相应的业务逻辑判断，最后响应客户端响应数据
     * @param user
     * @return  登陆成功返回用户数据给客户端，登陆失败返回出错信息
     * 注意：该方法的返回类型为User --> ResponseObject<User> --> 客户端接收部分的类型也要为User，不然会报错！！！
     */
    @RequestMapping(path = "/account_login")
    @ResponseBody
    public ResponseObject<User> userAccountLogin(@RequestBody User user) {
        // 获取客户端传入的登陆密码
        String clientLoginPwd = user.getLoginPwd();
        // 先进行用户登陆传过来的用户名和密码非空判断
        if (!StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getLoginPwd())) {
            // 获取返回值
            User userConfirmed = userService.loginVerification(user);
            // 判断客户端传入的该用户名是否存在
            if (userConfirmed != null) {
                // 判断客户端传入的密码和数据库中的密码是否一致
                if (clientLoginPwd.equals(userConfirmed.getLoginPwd())) {
                    return new ResponseObject<User>("登录成功！", 1, userConfirmed);
                }else {
                    return new ResponseObject<User>("用户名或密码错误！", 0);
                }
            } else {
                return new ResponseObject<User>("该用户不存在！", 0);
            }
        } else {
            return new ResponseObject<User>("用户名或密码不能为空！", 0);
        }
    }

/*    public ResponseObject<String> loginByPhone(@RequestBody User user){

    }*/

    @ResponseBody
    @RequestMapping(path = "/modify_nickname")
    public ResponseObject<User> modifyNickname(@RequestParam("new_nickname") String newNickname,
                                               @RequestParam("user_id") String userID) {
        if (newNickname != null && userID != null) {
            User userModified = userService.updateNickname(newNickname, userID);
            return new ResponseObject<User>("昵称修改成功！", 1, userModified);
        } else {
            return new ResponseObject<User>("昵称不能为空！", 0);
        }
    }

	@ResponseBody
	@RequestMapping(path = "/modify_password")
    public ResponseObject<String> modifyPassword(@RequestBody User user) {
        // 获取用户ID和用户要修改的密码
        String id = user.getId();
        String password = user.getLoginPwd();
        if (id != null && password != null) {
//            userService.updatePassword(id, password); 用该方式传递参数会出错
            userService.updatePassword(user);
            return  new ResponseObject<String>("密码修改成功！", 1);
        } else {
            return new ResponseObject<String>("修改出错！", 0);
        }
    }

    @ResponseBody
    @RequestMapping(path = "/set_payment")
    public ResponseObject<String> setPayment(@RequestBody User user) {
        String id = user.getId();
        String payPwd = user.getPayPwd();
        if (id != null && payPwd != null) {
            userService.setPayment(user);
            return  new ResponseObject<String>("设置支付密码成功！", 1);
        } else {
            return new ResponseObject<String>("设置支付密码出错！", 0);
        }
    }

    @ResponseBody
    @RequestMapping(path = "/bind_phone")
    public ResponseObject<String> bindPhone(@RequestParam("phone_number") String phoneNumber,
                                               @RequestParam("user_id") String userID) {
            userService.bindPhone(phoneNumber, userID);
            return new ResponseObject<String>("绑定成功！", 1);
    }

}
