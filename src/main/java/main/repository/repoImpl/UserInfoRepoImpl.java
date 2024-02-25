package main.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import main.entity.User;
import main.entity.UserInfo;
import main.repository.UserInfoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserInfoRepoImpl implements UserInfoRepository {
    @PersistenceContext
private final EntityManager entityManager;
    @Override
    public void updateUserInfo(UserInfo userInfo, long id) {
        UserInfo userInfo1 = entityManager.find(UserInfo.class, id);
        userInfo1.setBiography(userInfo.getBiography());
        userInfo1.setGender(userInfo.getGender());
        userInfo1.setFullName(userInfo.getFullName());
        userInfo1.setImageUrl(userInfo.getImageUrl());
        entityManager.merge(userInfo1);
    }

    @Override
    public UserInfo findUserInfoByUserId(long id) {
        return entityManager.find(User.class, id).getUserInfo();
    }
}
