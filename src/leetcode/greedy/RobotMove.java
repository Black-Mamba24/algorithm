package leetcode.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 -2：向左转 90 度
 -1：向右转 90 度
 1 <= x <= 9：向前移动 x 个单位长度
 在网格上有一些格子被视为障碍物。
 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 返回从原点到机器人的最大欧式距离的平方。

 示例 1：

 输入: commands = [4,-1,3], obstacles = []
 输出: 25
 解释: 机器人将会到达 (3, 4)

 思路：1. 表示方向的值先存起来，不要switch或if再做加减
 2. 环形循环取模技巧，正向+1取模，逆向+(mod - 1)取模
 3. set中使用string运行时间长，使用long保存两个int，但要保证这两个int是正数
 * Created by zhaiyi on 2018/9/27.
 */
public class RobotMove {
    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        System.out.println(robotMove.robotSim(new int[]{4,-1,3}, new int[][]{}));
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        int res = 0, x = 0, y = 0, des = 0;
        for (int i = 0; i < commands.length; i++) {
            int c = commands[i];
            if (c == -1) {
                des = (des + 1) % 4;
            } else if (c == -2) {
                des = (des + 3) % 4;
            } else {
                for (int j = 0; j < c; j ++) {
                    int tmp_x = x + dx[des];
                    int tmp_y = y + dy[des];
                    if (!set.contains(tmp_x + "," + tmp_y)) {
                        x = tmp_x;
                        y = tmp_y;
                        res = Math.max(res, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
