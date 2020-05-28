package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.GoodsPicture;
import cn.net.colin.entity.sysManage.GoodsPictureCriteria;

import java.util.List;

public interface GoodsPictureService {
    long countByExample(GoodsPictureCriteria example);

    GoodsPicture selectByPrimaryKey(Integer idAuto);

    List<GoodsPicture> selectByExample(GoodsPictureCriteria example);

    int deleteByPrimaryKey(Integer idAuto);

    int updateByPrimaryKeySelective(GoodsPicture record);

    int updateByPrimaryKey(GoodsPicture record);

    int deleteByExample(GoodsPictureCriteria example);

    int updateByExampleSelective(GoodsPicture record, GoodsPictureCriteria example);

    int updateByExample(GoodsPicture record, GoodsPictureCriteria example);

    int insert(GoodsPicture record);

    int insertSelective(GoodsPicture record);
}