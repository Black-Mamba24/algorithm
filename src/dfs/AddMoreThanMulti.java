package dfs;

import java.util.*;

/**
 *
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 *
 * 第一行输入一个正整数n(n ≤ 1000)
 * 第二行为n个数正整数xi(xi ≤ 1000)
 * 输出可以产生的幸运的袋子数
 *
 * 分析
 * 首先划归问题，问题需要序列的全排列，因此是深度搜索（dfs）问题，还需要适当的剪枝和去重
 * 在循环中递归即深度搜索
 * 如果满足sum > mul，必须包含1，否则不成立
 * 当sum > mul时找到一个结果并继续深度搜索
 * 注意首位出现1是必要条件，但还需跟后面的序列配合才算是一个有效结果，因此只继续深度搜索
 * 当出现sum <= mul且首位不是1时，后面加法再也追不上乘法，可以剪枝，且剪枝时需要把累加、累乘的值去掉
 * 当完成某个节点的深度遍历后，继续向同一层下一个节点搜索时，先把当前节点累加、累乘的值去掉，同时去重，即在同一层中，任意一个数字相同的球是对等的
 *   1  |   1  |   2
 * 1   2| 2    |
 * 2    |      |
 * a   b| c   d| e   f
 * a算出11,112
 * b算出12
 * cd 剪枝
 * ef sum==mul
 * Created by zhaiyi on 2018/8/22.
 */
public class AddMoreThanMulti {
    public static int sum = 0;
    public static int mul = 1;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tmp = scanner.nextInt();
        int[] array = new int[tmp];
        for (int i = 0; i < tmp; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        dfs(0, array);
        System.out.println(count);
    }

    public static void dfs(int index, int[] array) {
        for (int i = index; i < array.length; i++) {
            sum += array[i];
            mul *= array[i];
            if (sum > mul) {
                count++;
                dfs(i + 1, array);
            } else if (array[i] == 1) {
                dfs(i + 1, array);
            } else {
                sum -= array[i];
                mul /= array[i];
                break;
            }
            sum -= array[i];
            mul /= array[i];
            for (; i < array.length - 1 && array[i] == array[i + 1]; i++) {
//                System.out.println("去重" + i);
            }
        }
    }
}
