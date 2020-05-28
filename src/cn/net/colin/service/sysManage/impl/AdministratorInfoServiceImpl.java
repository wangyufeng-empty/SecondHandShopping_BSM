package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.AdministratorInfoDAO;
import cn.net.colin.entity.sysManage.AdministratorInfo;
import cn.net.colin.entity.sysManage.AdministratorInfoCriteria;
import cn.net.colin.service.sysManage.AdministratorInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorInfoServiceImpl implements AdministratorInfoService {
    @Autowired
    private AdministratorInfoDAO administratorInfoDAO;

    private static final Logger logger = LoggerFactory.getLogger(AdministratorInfoServiceImpl.class);

    public long countByExample(AdministratorInfoCriteria example) {
        long count = this.administratorInfoDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public AdministratorInfo selectByPrimaryKey(String adminId) {
        return this.administratorInfoDAO.selectByPrimaryKey(adminId);
    }

    public List<AdministratorInfo> selectByExample(AdministratorInfoCriteria example) {
        return this.administratorInfoDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(String adminId) {
        return this.administratorInfoDAO.deleteByPrimaryKey(adminId);
    }

    public int updateByPrimaryKeySelective(AdministratorInfo record) {
        return this.administratorInfoDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AdministratorInfo record) {
        return this.administratorInfoDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(AdministratorInfoCriteria example) {
        return this.administratorInfoDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(AdministratorInfo record, AdministratorInfoCriteria example) {
        return this.administratorInfoDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(AdministratorInfo record, AdministratorInfoCriteria example) {
        return this.administratorInfoDAO.updateByExample(record, example);
    }

    public int insert(AdministratorInfo record) {
        return this.administratorInfoDAO.insert(record);
    }

    public int insertSelective(AdministratorInfo record) {
        return this.administratorInfoDAO.insertSelective(record);
    }
}