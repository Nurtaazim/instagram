package main.repository;

import main.entity.UserInfo;

public interface UserInfoRepository {
    void updateUserInfo (UserInfo userInfo, long id);
    UserInfo findUserInfoByUserId (long id );
}
