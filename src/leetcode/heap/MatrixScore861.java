package leetcode.heap;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 思路：遍历行，如果翻转后更大，则翻转；遍历列，如果1的数量更少，则翻转。直到不能翻转为止
 */
public class MatrixScore861 {
    public static void main(String[] args) {
        MatrixScore861 matrixScore861 = new MatrixScore861();
        System.out.println(matrixScore861.matrixScore(new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {0, 1, 0}
        }));
    }

    public int matrixScore(int[][] A) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < A.length; i++) {
                if (check_line(A[i])) {
                    for (int j = 0; j < A[i].length; j++) {
                        A[i][j] ^= 1;
                        flag = true;
                    }
                }
            }

            for (int j = 0; j < A[0].length; j++) {
                int[] array = new int[A.length];
                for (int i = 0; i < A.length; i++) {
                    array[i] = A[i][j];
                }
                if (check_row(array)) {
                    for (int i = 0; i < A.length; i++) {
                        A[i][j] ^= 1;
                    }
                    flag = true;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A[i].length; j++) {
                sum <<= 1;
                sum += A[i][j];
            }
            res += sum;
        }
        return res;
    }

    public boolean check_line(int[] array) {
        int total = (int) (Math.pow(2, array.length) - 1);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum <<= 1;
            sum += array[i];
        }
        return sum * 2 < total;
    }

    public boolean check_row(int[] array) {
        int count = 0;
        for (int a : array) {
            count += a;
        }
        return count * 2 < array.length;
    }
}
