package cn.net.colin.dao.sysManage;

import cn.net.colin.entity.sysManage.OrderInfo;
import cn.net.colin.entity.sysManage.OrderInfoCriteria;
import cn.net.colin.entity.sysManage.OrderInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author sxf code generator
 * date:2020/04/30 18:43
 */
public interface OrderInfoDAO {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(OrderInfoCriteria example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(OrderInfoCriteria example);

    /** 
     * 根据ID删除
     * @param key
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(OrderInfoKey key);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(OrderInfo record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(OrderInfo record);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<OrderInfo> selectByExample(OrderInfoCriteria example);

    /** 
     * 根据ID查询
     * @param key
     * @return 返回查询的结果
     */
    OrderInfo selectByPrimaryKey(OrderInfoKey key);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoCriteria example);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoCriteria example);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(OrderInfo record);
}