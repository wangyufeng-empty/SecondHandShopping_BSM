package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.AnnouncementInfo;
import cn.net.colin.entity.sysManage.AnnouncementInfoCriteria;

import java.util.List;

public interface AnnouncementInfoService {
    long countByExample(AnnouncementInfoCriteria example);

    AnnouncementInfo selectByPrimaryKey(String announcementId);

    List<AnnouncementInfo> selectByExample(AnnouncementInfoCriteria example);

    int deleteByPrimaryKey(String announcementId);

    int updateByPrimaryKeySelective(AnnouncementInfo record);

    int updateByPrimaryKey(AnnouncementInfo record);

    int deleteByExample(AnnouncementInfoCriteria example);

    int updateByExampleSelective(AnnouncementInfo record, AnnouncementInfoCriteria example);

    int updateByExample(AnnouncementInfo record, AnnouncementInfoCriteria example);

    int insert(AnnouncementInfo record);

    int insertSelective(AnnouncementInfo record);
}