package cn.net.colin.service.sysManage.impl;

import cn.net.colin.common.utils.ImportExeclUtil;
import cn.net.colin.dao.sysManage.RealNameDAO;
import cn.net.colin.entity.sysManage.RealName;
import cn.net.colin.entity.sysManage.RealNameCriteria;
import cn.net.colin.service.sysManage.RealNameService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Service
public class RealNameServiceImpl implements RealNameService {
    @Autowired
    private RealNameDAO realNameDAO;

    private static final Logger logger = LoggerFactory.getLogger(RealNameServiceImpl.class);

    public long countByExample(RealNameCriteria example) {
        long count = this.realNameDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public RealName selectByPrimaryKey(String studentId) {
        return this.realNameDAO.selectByPrimaryKey(studentId);
    }

    public List<RealName> selectByExample(RealNameCriteria example) {
        return this.realNameDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(String studentId) {
        return this.realNameDAO.deleteByPrimaryKey(studentId);
    }

    public int updateByPrimaryKeySelective(RealName record) {
        return this.realNameDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RealName record) {
        return this.realNameDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(RealNameCriteria example) {
        return this.realNameDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(RealName record, RealNameCriteria example) {
        return this.realNameDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(RealName record, RealNameCriteria example) {
        return this.realNameDAO.updateByExample(record, example);
    }

    public int insert(RealName record) {
        return this.realNameDAO.insert(record);
    }

    public int insertSelective(RealName record) {
        return this.realNameDAO.insertSelective(record);
    }

    @Override
    public Map<String, Object> importRealName(MultipartFile file, HttpServletRequest request) {
        Map<String,Object> returnMap = new HashMap<>();
        try{
            Workbook wb = ImportExeclUtil.chooseWorkbook(file.getOriginalFilename(), file.getInputStream());
            RealName realName = new RealName();
            //导入excel列对应
            String[] cols=new String[]{"studentId","studentName"};
            //excel映射实体
            List<RealName> readDateList = ImportExeclUtil.readDateListT(wb, realName, 2, 0,cols);
            int saveNum = realNameDAO.insertBatch(readDateList);
            returnMap.put("saveNum",saveNum);
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnMap;
    }
}