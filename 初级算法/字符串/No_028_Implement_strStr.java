/**
 * @ClassName: No_028_Implement_strStr
 * @Description:
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @Author: XieQing
 * @Date: 2018/11/1 11:57
 * @Version: 1.0
 */
public class No_028_Implement_strStr {
    class SolutionA {
        public int strStr(String haystack, String needle) {
            int lenN = needle.length();
            int lenH = haystack.length();
            int indexN = 0;
            int indexH = 0;

            if (haystack.isEmpty() && !needle.isEmpty() || lenN > lenH) {
                return -1;
            }
            if (needle.isEmpty()) {
                return 0;
            }
            // 暴力匹配
            while (indexN < lenN && indexH < lenH) {
                if (haystack.charAt(indexH) == needle.charAt(indexN)) {
                    indexH++;
                    indexN++;
                } else {
                    indexH -= indexN - 1;
                    indexN = 0;
                }
            }
            if (indexN == lenN) {
                return indexH - indexN;
            }
            return -1;
        }
    }
    class SolutionB {
        public int strStr(String haystack, String needle) {
            // KMP
            int lenN = needle.length();
            int lenH = haystack.length();
            int indexN = 0;
            int indexH = 0;
            int[] _n = new int[lenN];

            if (haystack.isEmpty() && !needle.isEmpty() || lenN > lenH) {
                return -1;
            }
            if (needle.isEmpty()) {
                return 0;
            }

            // needle 建表
            int temp = _n[0] = -1;
            while (indexN < lenN - 1) {
                if (0 > temp || needle.charAt(indexN) == needle.charAt(temp)) {
                    _n[++indexN] = ++temp;
                } else {
                    temp = _n[temp];
                }
            }
            indexN = 0;

            while (indexN < lenN && indexH < lenH) {
                if ( 0 > indexN || haystack.charAt(indexH) == needle.charAt(indexN)) {
                    indexH++;
                    indexN++;
                } else {
                    indexN = _n[indexN];
                }
            }
            if (indexN == lenN) {
                return indexH - indexN;
            }
            return -1;
        }
    }
    class SolutionC {
        // 无聊刷分
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
}
