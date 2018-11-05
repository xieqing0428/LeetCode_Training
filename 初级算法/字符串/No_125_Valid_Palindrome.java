/**
 * @ClassName: No_125_Valid_Palindrome
 * @Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @Author: XieQing
 * @Date: 2018/10/31 00:39
 * @Version: 1.0
 */
public class No_125_Valid_Palindrome {
    class SolutionA {
        public boolean isPalindrome(String s) {
            if (s.equals("") || s.equals("null") ||s.equals(null)) {
                return true;
            }
            int start = 0;
            int end = s.length() - 1;
            int temp = 'A' - 'a';
            char c_start, c_end;

            while (start < end) {
                c_start = s.charAt(start);
                c_end = s.charAt(end);
                if (!(c_start >= 'a' && c_start <= 'z' || c_start >= '0' && c_start<= '9' || c_start >= 'A' && c_start <= 'Z')) {
                    start++;
                    continue;
                }
                if (!(c_end >= 'a' && c_end <= 'z' || c_end >= '0' && c_end <= '9' || c_end >= 'A' && c_end <= 'Z')) {
                    end--;
                    continue;
                }
                if (c_start == c_end || c_start - c_end == temp && (c_start >= 'a' && c_start <= 'z' || c_start >= 'A' && c_start <= 'Z') || c_end - c_start == temp && (c_start >= 'a' && c_start <= 'z' || c_start >= 'A' && c_start <= 'Z')) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
    class SolutionB {
        public boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }
            int head = 0, tail = s.length() - 1;
            char cHead, cTail;
            while(head <= tail) {
                cHead = s.charAt(head);
                cTail = s.charAt(tail);
                if (!Character.isLetterOrDigit(cHead)) {
                    head++;
                } else if(!Character.isLetterOrDigit(cTail)) {
                    tail--;
                } else {
                    if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                        return false;
                    }
                    head++;
                    tail--;
                }
            }
            return true;
        }
    }
}
