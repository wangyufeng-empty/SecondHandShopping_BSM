package cn.net.colin.dao.common;

import java.util.List;
import java.util.Map;

public interface ICommonDao {
    List<Map<String,Object>> fromVerifyByCode(Map<String, Object> map);
}
