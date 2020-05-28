package cn.net.colin.dao.sysManage;

import cn.net.colin.entity.sysManage.GoodsPicture;
import cn.net.colin.entity.sysManage.GoodsPictureCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sxf code generator
 * date:2020/05/03 15:09
 */
public interface GoodsPictureDAO {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(GoodsPictureCriteria example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(GoodsPictureCriteria example);

    /** 
     * 根据ID删除
     * @param idAuto 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(Integer idAuto);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(GoodsPicture record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(GoodsPicture record);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<GoodsPicture> selectByExample(GoodsPictureCriteria example);

    /** 
     * 根据ID查询
     * @param idAuto 主键ID
     * @return 返回查询的结果
     */
    GoodsPicture selectByPrimaryKey(Integer idAuto);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") GoodsPicture record, @Param("example") GoodsPictureCriteria example);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") GoodsPicture record, @Param("example") GoodsPictureCriteria example);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(GoodsPicture record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(GoodsPicture record);
}