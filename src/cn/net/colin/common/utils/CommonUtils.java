package cn.net.colin.common.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    /**
     * 获取32随机数
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 返回正则匹配到的字符串,多个以逗号分隔
     *
     * @param regex  正则
     * @param source 字符串
     * @return
     */
    public static List<String> getMatchers(String regex, String source) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    /**
     * 判断正则是否能匹配到该字符串
     *
     * @param regex  正则
     * @param source 字符串
     * @return
     * @author huangGuangming
     * @date 2019年8月22日
     */
    public static boolean checkMatcher(String regex, String source) {
        List<String> list = getMatchers(regex, source);
        if (list == null || list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 随机产生一个length长度的a-Z和0-9混合字符串
     *
     * @param length 长度
     * @return 随机字符串
     */
    public static String generateRandomStr(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
