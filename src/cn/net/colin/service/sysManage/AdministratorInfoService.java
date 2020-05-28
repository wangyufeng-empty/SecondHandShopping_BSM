package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.AdministratorInfo;
import cn.net.colin.entity.sysManage.AdministratorInfoCriteria;

import java.util.List;

public interface AdministratorInfoService {
    long countByExample(AdministratorInfoCriteria example);

    AdministratorInfo selectByPrimaryKey(String adminId);

    List<AdministratorInfo> selectByExample(AdministratorInfoCriteria example);

    int deleteByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(AdministratorInfo record);

    int updateByPrimaryKey(AdministratorInfo record);

    int deleteByExample(AdministratorInfoCriteria example);

    int updateByExampleSelective(AdministratorInfo record, AdministratorInfoCriteria example);

    int updateByExample(AdministratorInfo record, AdministratorInfoCriteria example);

    int insert(AdministratorInfo record);

    int insertSelective(AdministratorInfo record);
}