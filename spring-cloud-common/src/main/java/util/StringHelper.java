package util;

/**
 * @author zhouchao
 * @Description 字符串工具类
 * @date 2017/10/30 9:53
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
