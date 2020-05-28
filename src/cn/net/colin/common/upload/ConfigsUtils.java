package cn.net.colin.common.upload;

import java.io.*;
import java.util.Properties;
/**
 * 解析config.properties类
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class ConfigsUtils {

	private static ConfigsUtils configs;

	
	private String longProdImage;

	private ConfigsUtils() {

	}

	static Properties prop = null;
	static {
		prop = new Properties();
		try {
			String url = ConfigsUtils.class.getClassLoader().getResource("/").toURI().getPath()+"config.properties";
			InputStream	in = new FileInputStream(new File(url));
			prop.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static ConfigsUtils getConfigs() {
		if (configs == null) {
			configs = new ConfigsUtils();
			configs.setLongProdImage(prop.getProperty("longProdImage").trim());
		}
		return configs;
	}

	public String getLongProdImage() {
		return longProdImage;
	}

	public void setLongProdImage(String longProdImage) {
		this.longProdImage = longProdImage;
	}
}