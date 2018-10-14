package leetcode.array_string.double_array;

/**
 *我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。

 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）

 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。

 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。

 示例 1:
 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 输出: 0.0
 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。

 示例 2:
 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 输出: 0.5
 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。

 注意:
 poured 的范围[0, 10 ^ 9]。
 query_glass 和query_row 的范围 [0, 99]。

 思路：如果按照题意一杯一杯计算，逻辑复杂，因为涉及到多行数据修改和进位，应该假设每个杯子能承受很多水，将总量向下递推
 技巧一：使用更少的空间，二维数组按需分配
 技巧二：为满足100层，需要分配101层，保证第100层能顺利流下去，不会出现>1的情况
 ps：如果从一开始认为O(n^2)一定超时而放弃按层遍历，很可能不能解决问题，因此不管怎样应该大胆尝试，训练时也以竞赛思维做题
 * Created by zhaiyi on 2018/10/12.
 */
public class ChampagneTower799 {
    public static void main(String[] args) {
        ChampagneTower799 champagneTower799 = new ChampagneTower799();
        System.out.println(champagneTower799.champagneTower(100,10,10));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][];
        tower[0] = new double[1];
        tower[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            tower[i + 1] = new double[i + 2];
            for (int j = 0; j <= i; j++) {
                if (tower[i][j] > 1) {
                    tower[i + 1][j] += (tower[i][j] - 1) / 2;
                    tower[i + 1][j + 1] += (tower[i][j] - 1) / 2;
                    tower[i][j] = 1;
                }
            }
        }
        return tower[query_row][query_glass];
    }
}
