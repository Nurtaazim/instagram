package main.service;

import main.entity.UserInfo;

public interface UserInfoService {
    void updateUserInfo (UserInfo userInfo, long id);
    UserInfo findUserInfoByUserId (long id );
}
