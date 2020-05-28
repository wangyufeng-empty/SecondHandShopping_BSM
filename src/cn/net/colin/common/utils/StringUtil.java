package cn.net.colin.common.utils;

public class StringUtil {
	/**
	 * 字符串去除换行空格制表符
	 * @param str
	 * @return
	 * @author huangGuangming
	 * @date 2019年8月19日
	 */
	public static String repEmpty(String str){
		if(str==null){
			return str;
		}
		str = str.replace("\r", "").replace("\n", "").replace("\t", "").replace(" ", "");
		return str;
	}
	
	/**
	 * 判断字符串是否为空
	 * @return 为空返回true 不为空返回false
	 * @author huangGuangming
	 * @date 2019年8月19日
	 */
	public static boolean isEmpty(String str){
		str = repEmpty(str);
		boolean f = str==null||"".equals(str)||"null".equalsIgnoreCase(str) ? true : false;
		return f;
	}
	
	/**
	 * 把[a,b,c]转换成'a','b','c'
	 * @param stringArr
	 * @return
	 * @author huangGuangming
	 * @date 2019-4-8
	 */
	public static String stringArrAppendChar(String[] stringArr){
		if(stringArr==null||stringArr.length==0||(stringArr.length==1&&"".equals(stringArr[0]))){
			return "";
		}
		String result = "'";
		for (int i = 0; i < stringArr.length; i++) {
			result += stringArr[i]+"','";
		}
		result = result.substring(0,result.length()-2);
		return result;
	}
	
	/**
	 * 把 a,b,c 转换成'a','b','c'
	 * @param str
	 * @return
	 * @author huangGuangming
	 * @date 2019年9月10日
	 */
	public static String stringAppendChar(String str){
		if(isEmpty(str)){
			return str;
		}
		str = str.replace("'", "");
		return stringArrAppendChar(str.split(","));
	}

	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		StringBuffer sb = null;
		while (strLen < strLength) {
			sb = new StringBuffer();
			sb.append("0").append(str);// 左补0
			str = sb.toString();
			strLen = str.length();
		}
		return str;
	}
}
