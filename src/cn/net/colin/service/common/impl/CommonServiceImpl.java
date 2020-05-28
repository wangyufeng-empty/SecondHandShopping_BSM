package cn.net.colin.service.common.impl;

import cn.net.colin.dao.common.ICommonDao;
import cn.net.colin.service.common.ICommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements ICommonService {

    @Resource
    private ICommonDao iCommonDao;
    @Override
    public boolean fromVerifyByCode(Map<String, Object> map) {
       List<Map<String,Object>> listCode = iCommonDao.fromVerifyByCode(map);
        if(listCode.size()>0){
            return false;
        }
        return true;
    }
}
