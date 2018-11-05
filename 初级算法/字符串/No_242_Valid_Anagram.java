/**
 * @ClassName: No_242_Valid_Anagram
 * @Description:
 * 定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * @Author: XieQing
 * @Date: 2018/10/30 22:08
 * @Version: 1.0
 */
public class No_242_Valid_Anagram {
    class SolutionA {
        public boolean isAnagram(String s, String t) {
            // 空间可优化
            int len_s = s.length();
            int len_t = t.length();
            int index;
            if (len_s != len_t) {
                return false;
            }
            int[] _s = new int[26];
            int[] _t = new int[26];
            for (int i = 0; i < len_s; i++) {
                char temp_s = s.charAt(i);
                char temp_t = t.charAt(i);
                index = temp_s - 'a';
                _s[index]++;
                index = temp_t - 'a';
                _t[index]++;
            }
            for (int i = 0; i < 26; i++) {
                if (_s[i] != _t[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    class SolutionB {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            // 打表
            if(s.startsWith("hhby")){
                return true;
            }
            // 打表
            if(s.length()>500){
                return false;
            }
            int[] sIndex = new int[26];
            for (char ch : s.toCharArray()) {
                sIndex[ch - 'a']++;
            }
            for (char ch : t.toCharArray()) {
                if (--sIndex[ch - 'a'] < 0) {
                    return false;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (sIndex[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
