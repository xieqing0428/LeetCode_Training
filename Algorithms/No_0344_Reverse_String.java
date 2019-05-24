package 初级算法.字符串;

/**
 * @ClassName: No_0344_Reverse_String
 * @Description:
 *
 * 0344. 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * @Author: XieQing
 * @Date: 2018/10/29 22:39
 * @Version: 1.0
 */
public class No_0344_Reverse_String {
    class SolutionA {
        public String reverseString(String s) {
            int len = s.length();
            StringBuilder result = new StringBuilder(10000);
            for (int i = len - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            return result.toString();
        }
    }
    class SolutionB {
        public String reverseString(String s) {
            int start, end;
            char temp;
            char[] strArr = s.toCharArray();
            start=0;
            end=s.length()-1;
            while(start<end){
                if(strArr[start] != strArr[end]){
                    temp = strArr[end];
                    strArr[end] = strArr[start];
                    strArr[start] = temp;
                }
                start++;
                end--;
            }
            return new String(strArr);
        }
    }
}
