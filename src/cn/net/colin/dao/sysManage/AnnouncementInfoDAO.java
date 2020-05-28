package cn.net.colin.dao.sysManage;

import cn.net.colin.entity.sysManage.AnnouncementInfo;
import cn.net.colin.entity.sysManage.AnnouncementInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author sxf code generator
 * date:2020/04/30 18:43
 */
public interface AnnouncementInfoDAO {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(AnnouncementInfoCriteria example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(AnnouncementInfoCriteria example);

    /** 
     * 根据ID删除
     * @param announcementId 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(String announcementId);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(AnnouncementInfo record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(AnnouncementInfo record);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<AnnouncementInfo> selectByExample(AnnouncementInfoCriteria example);

    /** 
     * 根据ID查询
     * @param announcementId 主键ID
     * @return 返回查询的结果
     */
    AnnouncementInfo selectByPrimaryKey(String announcementId);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") AnnouncementInfo record, @Param("example") AnnouncementInfoCriteria example);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") AnnouncementInfo record, @Param("example") AnnouncementInfoCriteria example);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(AnnouncementInfo record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(AnnouncementInfo record);
}