package 初级算法.字符串;

/**
 * @ClassName: No_0387_First_Unique_Character_in_a_String
 * @Description:
 *
 * 0387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @Author: XieQing
 * @Date: 2018/10/30 20:48
 * @Version: 1.0
 */
public class No_0387_First_Unique_Character_in_a_String {
    class SolutionA {
        public int firstUniqChar(String s) {
            char[] result = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0;j < s.length(); j++) {
                    if (result[i] == result[j] && i != j) {
                        break;
                    } else if (j == s.length() - 1) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
    class SolutionB {
        public int firstUniqChar(String s) {
            int res = -1;

            for(char ch='a'; ch<='z'; ch++) {
                int index = s.indexOf(ch);
                if(index != -1 && index == s.lastIndexOf(ch)) {
                    res = res == -1?index:Math.min(res, index);
                }
            }
            return res;
        }
    }
}
