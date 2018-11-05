/**
 * @ClassName: No_036_Valid_Sudoku
 * @Description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @Author: XieQing
 * @Date: 2018/10/29 19:38
 * @Version: 1.0
 */
public class No_036_Valid_Sudoku {
    class SolutionA {
        public boolean isValidSudoku(char[][] board) {
            boolean[][][] validArray = new boolean[10][9][9];
            boolean[][] valid3 = new boolean[10][9];
            // Init
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j < 9; j++) {
                    valid3[i][j] = false;
                    for (int k = 0; k < 9; k++) {
                        validArray[i][j][k] = false;
                    }
                }
            }
            // Valid
            char temp;
            int pos, num;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    temp = board[i][j];
                    if (temp >= '0' && temp <= '9') {
                        num = temp - '0';
                        // Valid Row and Column
                        if (!validArray[num][i][j]) {
                            for (int k = 0; k < 9; k++) {
                                validArray[num][i][k] = true;
                                validArray[num][k][j] = true;
                            }
                        } else {
                            return false;
                        }
                        // Valid 3x3
                        pos = 3 * (i / 3) + (j / 3);
                        if (!valid3[num][pos]) {
                            valid3[num][pos] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    class SolutionB {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++){
                int[] row = new int[9];
                int[] line = new int[9];
                int[] three = new int[9];
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                for (int j = 0; j < 9; j++){
                    char cl = board[i][j];
                    char cr = board[j][i];
                    if (cl != '.'){
                        line[cl - '1']++;
                        if (line[cl - '1'] >= 2)
                            return false;
                    }
                    if (cr != '.'){
                        row[cr - '1']++;
                        if (row[cr - '1'] >= 2)
                            return false;
                    }
                    char c =board[RowIndex + j/3][ColIndex + j%3];
                    if (c != '.'){
                        three[c - '1']++;
                        if (three[c - '1'] >=2)
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
