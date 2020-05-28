package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.AnnouncementInfoDAO;
import cn.net.colin.entity.sysManage.AnnouncementInfo;
import cn.net.colin.entity.sysManage.AnnouncementInfoCriteria;
import cn.net.colin.service.sysManage.AnnouncementInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementInfoServiceImpl implements AnnouncementInfoService {
    @Autowired
    private AnnouncementInfoDAO announcementInfoDAO;

    private static final Logger logger = LoggerFactory.getLogger(AnnouncementInfoServiceImpl.class);

    public long countByExample(AnnouncementInfoCriteria example) {
        long count = this.announcementInfoDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public AnnouncementInfo selectByPrimaryKey(String announcementId) {
        return this.announcementInfoDAO.selectByPrimaryKey(announcementId);
    }

    public List<AnnouncementInfo> selectByExample(AnnouncementInfoCriteria example) {
        return this.announcementInfoDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(String announcementId) {
        return this.announcementInfoDAO.deleteByPrimaryKey(announcementId);
    }

    public int updateByPrimaryKeySelective(AnnouncementInfo record) {
        return this.announcementInfoDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AnnouncementInfo record) {
        return this.announcementInfoDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(AnnouncementInfoCriteria example) {
        return this.announcementInfoDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(AnnouncementInfo record, AnnouncementInfoCriteria example) {
        return this.announcementInfoDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(AnnouncementInfo record, AnnouncementInfoCriteria example) {
        return this.announcementInfoDAO.updateByExample(record, example);
    }

    public int insert(AnnouncementInfo record) {
        return this.announcementInfoDAO.insert(record);
    }

    public int insertSelective(AnnouncementInfo record) {
        return this.announcementInfoDAO.insertSelective(record);
    }
}