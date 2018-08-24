package other;

import java.util.Scanner;

/**
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 * 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 *
 * 11XX11XX
 * 11XX11XX
 * XX11XX11
 * XX11XX11
 * 将2、3，1、4行合并成一行，简化
 * Created by zhaiyi on 2018/8/21.
 */
public class DistanceNotTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int row = scanner.nextInt();
        int max = 0;
        for (int i = 0; i < 2; i++) {
            int row_max = (line / 4 * 2) + (line % 4 <= 2 ? line % 4 : 2);
            if (row <= 2) {
                max = Math.max(row_max * row, max);
            } else {
                if (row % 2 == 1) {
                    max = Math.max(line * (row - 1) / 2 + row_max, max);
                } else {
                    max = Math.max(line * row / 2, max);
                }
            }
            int tmp = line;
            line = row;
            row = tmp;
        }
        System.out.println(max);
    }
}
