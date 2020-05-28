package cn.net.colin.dao.sysManage;

import cn.net.colin.entity.sysManage.GoodsInfo;
import cn.net.colin.entity.sysManage.GoodsInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author sxf code generator
 * date:2020/04/30 18:43
 */
public interface GoodsInfoDAO {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(GoodsInfoCriteria example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(GoodsInfoCriteria example);

    /** 
     * 根据ID删除
     * @param goodsId 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(String goodsId);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(GoodsInfo record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(GoodsInfo record);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<GoodsInfo> selectByExample(GoodsInfoCriteria example);

    /** 
     * 根据ID查询
     * @param goodsId 主键ID
     * @return 返回查询的结果
     */
    GoodsInfo selectByPrimaryKey(String goodsId);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") GoodsInfo record, @Param("example") GoodsInfoCriteria example);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") GoodsInfo record, @Param("example") GoodsInfoCriteria example);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(GoodsInfo record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(GoodsInfo record);
}