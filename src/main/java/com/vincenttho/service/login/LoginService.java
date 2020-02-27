package com.vincenttho.service.login;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @className:com.vincent.service.LoginService
 * @description:
 * @version:v1.0.0
 * @author: VincentHo
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019/10/14     VincentHo       v1.0.0        create
 */
@FeignClient(name = "wexinLogin", url = "https://api.weixin.qq.com")
public interface LoginService {

    @RequestMapping(value="/sns/jscode2session",method= RequestMethod.GET)
    JSONObject getEngineMesasge(
            @RequestParam("appId") String appId,
            @RequestParam("secret") String secret,
            @RequestParam("js_code") String jsCode,
            @RequestParam("grant_type") String grantType
    );

}