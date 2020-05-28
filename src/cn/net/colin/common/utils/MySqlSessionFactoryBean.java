package cn.net.colin.common.utils;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;
/**
 * 解决mybatis Mapper xml文件 错误引起的程序启动卡死（没有任何报错信息，控制台卡死）问�?
 * @author sxf
 *
 */
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        try {
            return super.buildSqlSessionFactory();
        } catch (NestedIOException e) {
            //- XML有错误时打印异常
            e.printStackTrace();
            throw new NestedIOException("加载Mapper配置文件异常: " + e);
        }
    }

}
