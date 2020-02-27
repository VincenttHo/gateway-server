package com.vincenttho.service.user;

import com.vincenttho.model.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @className:com.vincent.service.base.UserInfoDO
 * @description:
 * @version:v1.0.0
 * @author: VincentHo
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019/10/10     VincentHo       v1.0.0        create
 */
@Entity
@Table(name = "t_user_info")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfoDO extends BaseDO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;

    @Column(length = 32)
    private String nickName;

    @Column(length = 32)
    private String openId;

    @Column(length = 100)
    private String avatarUrl;

    @Column(length = 10)
    private String gender;

    @Column(length = 32)
    private String country;

    @Column(length = 32)
    private String province;

    @Column(length = 32)
    private String city;

}