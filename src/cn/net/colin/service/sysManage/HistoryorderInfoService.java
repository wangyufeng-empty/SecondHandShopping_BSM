package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.HistoryorderInfo;
import cn.net.colin.entity.sysManage.HistoryorderInfoCriteria;

import java.util.List;

public interface HistoryorderInfoService {
    long countByExample(HistoryorderInfoCriteria example);

    HistoryorderInfo selectByPrimaryKey(cn.net.colin.entity.sysManage.HistoryorderInfoKey key);

    List<HistoryorderInfo> selectByExample(HistoryorderInfoCriteria example);

    int deleteByPrimaryKey(cn.net.colin.entity.sysManage.HistoryorderInfoKey key);

    int updateByPrimaryKeySelective(HistoryorderInfo record);

    int updateByPrimaryKey(HistoryorderInfo record);

    int deleteByExample(HistoryorderInfoCriteria example);

    int updateByExampleSelective(HistoryorderInfo record, HistoryorderInfoCriteria example);

    int updateByExample(HistoryorderInfo record, HistoryorderInfoCriteria example);

    int insert(HistoryorderInfo record);

    int insertSelective(HistoryorderInfo record);
}