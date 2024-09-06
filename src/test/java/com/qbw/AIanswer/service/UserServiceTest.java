package com.qbw.AIanswer.service;

import javax.annotation.Resource;

import com.qbw.AIanswer.model.entity.User;
import com.qbw.AIanswer.model.vo.LoginUserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import static com.qbw.AIanswer.service.impl.UserServiceImpl.SALT;

/**
 * 用户服务测试
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        try {
            long result = userService.userRegister(userAccount, userPassword, checkPassword);
            Assertions.assertEquals(-1, result);
            userAccount = "yu";
            result = userService.userRegister(userAccount, userPassword, checkPassword);
            Assertions.assertEquals(-1, result);
        } catch (Exception e) {

        }
    }

    @Test
    void getPassword(){
        String password = "qbw123456789";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());
        System.out.println(encryptPassword);
    }

    @Test
    void getUser() {

        LoginUserVO loginUserVO = userService.userLogin("qbw_shu", "qbw123456789");
        if (loginUserVO != null) {
            System.out.println(loginUserVO);
        } else {
            System.out.println("用户不存在");
        }
    }
}
