package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.GoodsInfo;
import cn.net.colin.entity.sysManage.GoodsInfoCriteria;

import java.util.List;

public interface GoodsInfoService {
    long countByExample(GoodsInfoCriteria example);

    GoodsInfo selectByPrimaryKey(String goodsId);

    List<GoodsInfo> selectByExample(GoodsInfoCriteria example);

    int deleteByPrimaryKey(String goodsId);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    int deleteByExample(GoodsInfoCriteria example);

    int updateByExampleSelective(GoodsInfo record, GoodsInfoCriteria example);

    int updateByExample(GoodsInfo record, GoodsInfoCriteria example);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);
}