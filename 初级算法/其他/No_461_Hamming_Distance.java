/**
 * @ClassName: No_461_Hamming_Distance
 * @Description:
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * @Author: XieQing
 * @Date: 2018/11/6 22:05
 * @Version: 1.0
 */
public class No_461_Hamming_Distance {
    class SolutionA {
        public int hammingDistance(int x, int y) {
            int result = 0;
            for (int i = 0; i < 32; i++, x >>>= 1, y >>>= 1) {
                if ((x & 1) != (y & 1)) {
                    result++;
                }
            }
            return result;
        }
    }
    class SolutionB {
        public int hammingDistance(int x, int y) {
            if((x^y)==0){
                return 0;
            }
            return (x^y)%2 + hammingDistance(x/2,y/2);
        }
    }
}
