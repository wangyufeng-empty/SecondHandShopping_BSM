package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.UserInfoDAO;
import cn.net.colin.entity.sysManage.UserInfo;
import cn.net.colin.entity.sysManage.UserInfoCriteria;
import cn.net.colin.service.sysManage.UserInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDAO userInfoDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    public long countByExample(UserInfoCriteria example) {
        long count = this.userInfoDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public UserInfo selectByPrimaryKey(String userId) {
        return this.userInfoDAO.selectByPrimaryKey(userId);
    }

    public List<UserInfo> selectByExample(UserInfoCriteria example) {
        return this.userInfoDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(String userId) {
        return this.userInfoDAO.deleteByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(UserInfo record) {
        return this.userInfoDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserInfo record) {
        return this.userInfoDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(UserInfoCriteria example) {
        return this.userInfoDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(UserInfo record, UserInfoCriteria example) {
        return this.userInfoDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(UserInfo record, UserInfoCriteria example) {
        return this.userInfoDAO.updateByExample(record, example);
    }

    public int insert(UserInfo record) {
        return this.userInfoDAO.insert(record);
    }

    public int insertSelective(UserInfo record) {
        return this.userInfoDAO.insertSelective(record);
    }
}