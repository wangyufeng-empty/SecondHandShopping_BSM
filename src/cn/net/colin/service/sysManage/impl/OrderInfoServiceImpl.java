package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.OrderInfoDAO;
import cn.net.colin.entity.sysManage.OrderInfo;
import cn.net.colin.entity.sysManage.OrderInfoCriteria;
import cn.net.colin.service.sysManage.OrderInfoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoDAO orderInfoDAO;

    private static final Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    public long countByExample(OrderInfoCriteria example) {
        long count = this.orderInfoDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public OrderInfo selectByPrimaryKey(cn.net.colin.entity.sysManage.OrderInfoKey key) {
        return this.orderInfoDAO.selectByPrimaryKey(key);
    }

    public List<OrderInfo> selectByExample(OrderInfoCriteria example) {
        return this.orderInfoDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(cn.net.colin.entity.sysManage.OrderInfoKey key) {
        return this.orderInfoDAO.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(OrderInfo record) {
        return this.orderInfoDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OrderInfo record) {
        return this.orderInfoDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(OrderInfoCriteria example) {
        return this.orderInfoDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(OrderInfo record, OrderInfoCriteria example) {
        return this.orderInfoDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(OrderInfo record, OrderInfoCriteria example) {
        return this.orderInfoDAO.updateByExample(record, example);
    }

    public int insert(OrderInfo record) {
        return this.orderInfoDAO.insert(record);
    }

    public int insertSelective(OrderInfo record) {
        return this.orderInfoDAO.insertSelective(record);
    }
}