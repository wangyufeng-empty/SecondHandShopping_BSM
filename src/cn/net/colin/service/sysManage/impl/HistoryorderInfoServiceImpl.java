package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.HistoryorderInfoDAO;
import cn.net.colin.entity.sysManage.HistoryorderInfo;
import cn.net.colin.entity.sysManage.HistoryorderInfoCriteria;
import cn.net.colin.service.sysManage.HistoryorderInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryorderInfoServiceImpl implements HistoryorderInfoService {
    @Autowired
    private HistoryorderInfoDAO historyorderInfoDAO;

    private static final Logger logger = LoggerFactory.getLogger(HistoryorderInfoServiceImpl.class);

    public long countByExample(HistoryorderInfoCriteria example) {
        long count = this.historyorderInfoDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public HistoryorderInfo selectByPrimaryKey(cn.net.colin.entity.sysManage.HistoryorderInfoKey key) {
        return this.historyorderInfoDAO.selectByPrimaryKey(key);
    }

    public List<HistoryorderInfo> selectByExample(HistoryorderInfoCriteria example) {
        return this.historyorderInfoDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(cn.net.colin.entity.sysManage.HistoryorderInfoKey key) {
        return this.historyorderInfoDAO.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(HistoryorderInfo record) {
        return this.historyorderInfoDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(HistoryorderInfo record) {
        return this.historyorderInfoDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(HistoryorderInfoCriteria example) {
        return this.historyorderInfoDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(HistoryorderInfo record, HistoryorderInfoCriteria example) {
        return this.historyorderInfoDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(HistoryorderInfo record, HistoryorderInfoCriteria example) {
        return this.historyorderInfoDAO.updateByExample(record, example);
    }

    public int insert(HistoryorderInfo record) {
        return this.historyorderInfoDAO.insert(record);
    }

    public int insertSelective(HistoryorderInfo record) {
        return this.historyorderInfoDAO.insertSelective(record);
    }
}