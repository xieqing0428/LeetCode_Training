package 初级算法.字符串;

/**
 * @ClassName: No_0014_Longest_Common_Prefix
 * @Description:
 *
 * 0014. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author: XieQing
 * @Date: 2018/11/1 20:16
 * @Version: 1.0
 */
public class No_0014_Longest_Common_Prefix {
    class SolutionA {
        public String longestCommonPrefix(String[] strs) {
            int len = strs.length;
            int index = 0;
            char temp;
            String result = "";
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    index = Integer.MAX_VALUE;
                }
                if (strs[i].isEmpty()) {
                    return "";
                }
                index = Math.min(index, strs[i].length());
            }
            for (int i = 0; i < index; i++) {
                temp = strs[0].charAt(i);
                for (int j = 1; j < len; j++) {
                    if (strs[j].charAt(i) != temp) {
                        return result;
                    }
                }
                // 加法
                result += String.valueOf(temp);
            }
            return result;
        }
    }

    class SolutionB {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            int minLength = strs[0].length();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < minLength) {
                    prefix = strs[i];
                    minLength = prefix.length();
                }
            }
            // 减法
            for (int i = 0; i < strs.length; i++) {
                String temp = strs[i].substring(0, prefix.length());
                while (!temp.equals(prefix) && prefix.length() > 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    temp = temp.substring(0, temp.length() - 1);
                }
                if (prefix.length() == 0) {
                    break;
                }
            }
            return prefix;
        }
    }
}
