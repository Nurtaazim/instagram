package main.service.servImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.UserInfo;
import main.repository.UserInfoRepository;
import main.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserInfoServImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;
    @Override
    public void updateUserInfo(UserInfo userInfo, long id) {
        userInfoRepository.updateUserInfo(userInfo, id);
    }

    @Override
    public UserInfo findUserInfoByUserId(long id) {
        return userInfoRepository.findUserInfoByUserId(id);
    }
}
