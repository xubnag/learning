package string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/10 9:02 AM
 * @Description String类型处理
 */
public class StringUtils {

    public static void main(String[] args) {
        String str = "1,2,3，4，25，31,30，100";
        //从"多个数据"string，提取出单个数据
        List<Long> strNew = splitStringToList(str);
    }

    /**
     * 从"多个数据"string，提取出单个数据
     * @param str
     * @return
     */
    private static List<Long> splitStringToList(String str) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return null;
        }
        //正则表达式：同时兼容中英文逗号
        String regex = ",|，";
        return Arrays.stream(str.split(regex))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());
    }

}