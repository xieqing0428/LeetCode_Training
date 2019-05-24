package 初级算法.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: No_0118_Pascals_Triangle
 * @Description:
 *
 * 0118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @Author: XieQing
 * @Date: 2018/11/6 23:14
 * @Version: 1.0
 */
public class No_0118_Pascals_Triangle {
    class SolutionA {
        public List<List<Integer>> generate(int numRows) {
            if (numRows < 0) {
                return null;
            }
            List<List<Integer>> result = new ArrayList<>();
            if (numRows >= 1) {
                List<Integer> current = new ArrayList<>();
                current.add(1);
                result.add(current);
            }
            if (numRows >= 2) {
                List<Integer> current = new ArrayList<>();
                current.add(1);
                current.add(1);
                result.add(current);
            }
            if (numRows >= 3) {
                for (int i = 3; i <= numRows; i++) {
                    List<Integer> current = new ArrayList<>();
                    List<Integer> prev = result.get(i - 2);
                    current.add(1);
                    for (int j = 2; j <= i - 1; j++) {
                        current.add(prev.get(j - 2) + prev.get(j - 1));
                    }
                    current.add(1);
                    result.add(current);
                }
            }
            return result;
        }
    }
    class SolutionB {
        // 官方
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();

            // First base case; if user requests zero rows, they get zero rows.
            if (numRows == 0) {
                return triangle;
            }

            // Second base case; first row is always [1].
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for (int rowNum = 1; rowNum < numRows; rowNum++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(rowNum-1);

                // The first row element is always 1.
                row.add(1);

                // Each triangle element (other than the first and last of each row)
                // is equal to the sum of the elements above-and-to-the-left and
                // above-and-to-the-right.
                for (int j = 1; j < rowNum; j++) {
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }

                // The last row element is always 1.
                row.add(1);

                triangle.add(row);
            }

            return triangle;
        }
    }
}
