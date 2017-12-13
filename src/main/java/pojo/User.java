package pojo;

/**
 * @ClassName: User
 * @Description: 用于封装用户数据的实体类
 * @Author Stefan
 * @Date 2017/10/8 10:09
 */
public class User {
    /**
     * 注意：服务端的实体类属性的命名一定要和客户端实体类的命名一致！！！不然会报错！
     */
    private String id;          // 用户ID
    private String username;    // 用户名
    private String loginPwd;    // 登录密码
    private String payPwd;      // 支付密码
    private String gender;      // 性别
    private String email;       // 邮箱
    private String tel;         // 电话
    private String integral;    // 积分
    private String headUrl;    // 用户头像地址
    private String nickname;    // 用户昵称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", payPwd='" + payPwd + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", integral='" + integral + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
