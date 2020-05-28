package cn.net.colin.dao.sysManage;

import cn.net.colin.entity.sysManage.RealName;
import cn.net.colin.entity.sysManage.RealNameCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author sxf code generator
 * date:2020/05/02 15:30
 */
public interface RealNameDAO {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(RealNameCriteria example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(RealNameCriteria example);

    /** 
     * 根据ID删除
     * @param studentId 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(String studentId);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(RealName record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(RealName record);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<RealName> selectByExample(RealNameCriteria example);

    /** 
     * 根据ID查询
     * @param studentId 主键ID
     * @return 返回查询的结果
     */
    RealName selectByPrimaryKey(String studentId);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") RealName record, @Param("example") RealNameCriteria example);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") RealName record, @Param("example") RealNameCriteria example);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(RealName record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(RealName record);

    /**
     * 批量保存
     * @param readDateList
     * @return
     */
    int insertBatch(List<RealName> readDateList);
}