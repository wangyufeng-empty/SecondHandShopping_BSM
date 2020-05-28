package cn.net.colin.service.sysManage;

import cn.net.colin.entity.sysManage.RealName;
import cn.net.colin.entity.sysManage.RealNameCriteria;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface RealNameService {
    long countByExample(RealNameCriteria example);

    RealName selectByPrimaryKey(String studentId);

    List<RealName> selectByExample(RealNameCriteria example);

    int deleteByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(RealName record);

    int updateByPrimaryKey(RealName record);

    int deleteByExample(RealNameCriteria example);

    int updateByExampleSelective(RealName record, RealNameCriteria example);

    int updateByExample(RealName record, RealNameCriteria example);

    int insert(RealName record);

    int insertSelective(RealName record);

    /**
     * 批量导入实名库
     * @param file
     * @param request
     * @return
     */
    Map<String, Object> importRealName(MultipartFile file, HttpServletRequest request);
}