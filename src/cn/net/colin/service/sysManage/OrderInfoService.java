package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.OrderInfo;
import cn.net.colin.entity.sysManage.OrderInfoCriteria;

import java.util.List;

public interface OrderInfoService {
    long countByExample(OrderInfoCriteria example);

    OrderInfo selectByPrimaryKey(cn.net.colin.entity.sysManage.OrderInfoKey key);

    List<OrderInfo> selectByExample(OrderInfoCriteria example);

    int deleteByPrimaryKey(cn.net.colin.entity.sysManage.OrderInfoKey key);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int deleteByExample(OrderInfoCriteria example);

    int updateByExampleSelective(OrderInfo record, OrderInfoCriteria example);

    int updateByExample(OrderInfo record, OrderInfoCriteria example);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);
}