package cn.net.colin.common.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @ClassName: DynamicDataSource
 * @Description: 数据库切换功能类(spring-mybatis.xml中有体现 当需要操作其他数据库时，调用
 *               
 * 调用方法            DynamicDataSource.setCustomerType(DynamicDataSource.MASTER);
 * @author sxf
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 数据采集系统主库DAS
	 */
	public static final String MASTER = "MASTER";
	/**
	 * 创建线程链接，用于切换数据库
	 */
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	/**
	 *
	 * @Title: setCustomerType 
	 * @Description: 设置数据
	 * @param @param customerType    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	/**
	 *
	 * @Title: getCustomerType 
	 * @Description: 获取当前使用的数据源
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getCustomerType() {
		return contextHolder.get();
	}
	
	/**
	 *
	 * @Title: clearCustomerType 
	 * @Description: 清除当前数据
	 * @return void    返回类型
	 * @throws
	 */
	public static void clearCustomerType() {
		contextHolder.remove();
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return getCustomerType();
	}
}