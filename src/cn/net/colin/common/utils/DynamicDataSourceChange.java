package cn.net.colin.common.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 动态切换数据源
 */
public class DynamicDataSourceChange {

    private static Logger logger = LogManager.getLogger(DynamicDataSourceChange.class);

    private static  Boolean enableSlave=false;
    static {
//        InputStream in = DynamicDataSourceChange.class.getResourceAsStream("/config.properties");
//        Properties prop = new Properties();
        try{

//            prop.load(in);
            String es =PropertyUtil.getProperty("enable_slave","false");
            if("true".equalsIgnoreCase(es)){
                enableSlave=true;
            }
        }catch (Exception e){
            logger.error("DynaminDataSourceChange.class加载config.properties错误");
            e.printStackTrace();
        }
    }

    public static void changeDataSource(String customerType){

        //判断配置文件是否启用动态切换数据源
        if(enableSlave){
            DynamicDataSource.setCustomerType(customerType);
        }

    }


}
