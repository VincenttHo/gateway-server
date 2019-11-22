package com.vincent.service.login;

import com.vincent.model.ResultBean;
import com.vincent.service.user.UserInfoDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className:com.vincent.service.login.LoginController
 * @description:
 * @version:v1.0.0
 * @author: VincentHo
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019/10/18     VincentHo       v1.0.0        create
 */
@RestController
@RequestMapping("/api/auth/login")
public class LoginController {

    @GetMapping("")
    ResultBean<TokenDTO> login() {

        TokenDTO token = new TokenDTO();
        token.setAccessToken("SDsDfwefJWhj112323b234hposDNFSIcsDWeois90w3e04sdfgeFWew=wejklol");
        UserInfoDO userInfo = new UserInfoDO();
        userInfo.setOpenId("442313=123");
        userInfo.setNickName("锟斤拷");
        userInfo.setGender("男");
        token.setUserInfo(userInfo);
        return new ResultBean<>(token);

    }

}