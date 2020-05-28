package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.GoodsInfoDAO;
import cn.net.colin.entity.sysManage.GoodsInfo;
import cn.net.colin.entity.sysManage.GoodsInfoCriteria;
import cn.net.colin.service.sysManage.GoodsInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Autowired
    private GoodsInfoDAO goodsInfoDAO;

    private static final Logger logger = LoggerFactory.getLogger(GoodsInfoServiceImpl.class);

    public long countByExample(GoodsInfoCriteria example) {
        long count = this.goodsInfoDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public GoodsInfo selectByPrimaryKey(String goodsId) {
        return this.goodsInfoDAO.selectByPrimaryKey(goodsId);
    }

    public List<GoodsInfo> selectByExample(GoodsInfoCriteria example) {
        return this.goodsInfoDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(String goodsId) {
        return this.goodsInfoDAO.deleteByPrimaryKey(goodsId);
    }

    public int updateByPrimaryKeySelective(GoodsInfo record) {
        return this.goodsInfoDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(GoodsInfo record) {
        return this.goodsInfoDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(GoodsInfoCriteria example) {
        return this.goodsInfoDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(GoodsInfo record, GoodsInfoCriteria example) {
        return this.goodsInfoDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(GoodsInfo record, GoodsInfoCriteria example) {
        return this.goodsInfoDAO.updateByExample(record, example);
    }

    public int insert(GoodsInfo record) {
        return this.goodsInfoDAO.insert(record);
    }

    public int insertSelective(GoodsInfo record) {
        return this.goodsInfoDAO.insertSelective(record);
    }
}