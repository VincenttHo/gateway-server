package com.vincent.service.login;

import com.vincent.service.user.UserInfoDO;
import lombok.Data;

/**
 * @className:com.vincent.service.login.TokenDTO
 * @description:
 * @version:v1.0.0
 * @author: VincentHo
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019/10/18     VincentHo       v1.0.0        create
 */
@Data
public class TokenDTO {

    private UserInfoDO userInfo;

    private String accessToken;

}