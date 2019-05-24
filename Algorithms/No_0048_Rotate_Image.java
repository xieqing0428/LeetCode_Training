package 初级算法.数组;

/**
 * @ClassName: No_0048_Rotate_Image
 * @Description:
 *
 * 0048. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * @Author: XieQing
 * @Date: 2018/10/29 21:58
 * @Version: 1.0
 */
public class No_0048_Rotate_Image {
    class SolutionA {
        public void rotate(int[][] matrix) {
            int index = matrix.length;
            int temp;
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j < index - 1 - i; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[index - 1 - j][i];
                    matrix[index - 1 - j][i] = matrix[index - 1 - i][index - 1 - j];
                    matrix[index - 1 - i][index - 1 - j] = matrix[j][index - 1 - i];
                    matrix[j][index - 1 - i] = temp;
                }
            }
        }
    }
}
