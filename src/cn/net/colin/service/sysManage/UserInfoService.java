package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.UserInfo;
import cn.net.colin.entity.sysManage.UserInfoCriteria;

import java.util.List;

public interface UserInfoService {
    long countByExample(UserInfoCriteria example);

    UserInfo selectByPrimaryKey(String userId);

    List<UserInfo> selectByExample(UserInfoCriteria example);

    int deleteByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int deleteByExample(UserInfoCriteria example);

    int updateByExampleSelective(UserInfo record, UserInfoCriteria example);

    int updateByExample(UserInfo record, UserInfoCriteria example);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);
}