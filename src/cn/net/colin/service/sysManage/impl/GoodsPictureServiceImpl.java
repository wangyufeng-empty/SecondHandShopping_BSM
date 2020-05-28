package cn.net.colin.service.sysManage.impl;

import cn.net.colin.dao.sysManage.GoodsPictureDAO;
import cn.net.colin.entity.sysManage.GoodsPicture;
import cn.net.colin.entity.sysManage.GoodsPictureCriteria;
import cn.net.colin.service.sysManage.GoodsPictureService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsPictureServiceImpl implements GoodsPictureService {
    @Autowired
    private GoodsPictureDAO goodsPictureDAO;

    private static final Logger logger = LoggerFactory.getLogger(GoodsPictureServiceImpl.class);

    public long countByExample(GoodsPictureCriteria example) {
        long count = this.goodsPictureDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public GoodsPicture selectByPrimaryKey(Integer idAuto) {
        return this.goodsPictureDAO.selectByPrimaryKey(idAuto);
    }

    public List<GoodsPicture> selectByExample(GoodsPictureCriteria example) {
        return this.goodsPictureDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer idAuto) {
        return this.goodsPictureDAO.deleteByPrimaryKey(idAuto);
    }

    public int updateByPrimaryKeySelective(GoodsPicture record) {
        return this.goodsPictureDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(GoodsPicture record) {
        return this.goodsPictureDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(GoodsPictureCriteria example) {
        return this.goodsPictureDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(GoodsPicture record, GoodsPictureCriteria example) {
        return this.goodsPictureDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(GoodsPicture record, GoodsPictureCriteria example) {
        return this.goodsPictureDAO.updateByExample(record, example);
    }

    public int insert(GoodsPicture record) {
        return this.goodsPictureDAO.insert(record);
    }

    public int insertSelective(GoodsPicture record) {
        return this.goodsPictureDAO.insertSelective(record);
    }
}