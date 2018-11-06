import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: No_412_Fizz_Buzz
 * @Description:
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * @Author: XieQing
 * @Date: 2018/11/6 19:17
 * @Version: 1.0
 */
public class No_412_Fizz_Buzz {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> result = new LinkedList<>();
            if (n == 0) {
                return new LinkedList<String>();
            }
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    result.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    result.add("Fizz");
                } else if (i % 5 == 0) {
                    result.add("Buzz");
                } else {
                    result.add(String.valueOf(i));
                }
            }
            return result;
        }
    }
}
