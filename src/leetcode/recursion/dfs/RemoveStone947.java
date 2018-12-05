package leetcode.recursion.dfs;

/**
 * 移除最多的同行或同列石头
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 现在，move 操作将会移除与网格上的另一块石头共享一列或一行的（一个）石头。
 * 我们最多能执行多少次 move 操作？（最多能移除多少个石头）
 * 解释：所有能联通的石头组成一个分组，不同分组之间互斥，最终求有多少个分组，因为每个分组最终会移除只剩一个石头，不同分组之间不能移除了
 * 用深度遍历方式遍历寻找属于同一个分组的石头，最终用石头总数 - 分组数，就是最多能移除的石头树
 */
public class RemoveStone947 {
    public boolean[] checkArray;

    public int removeStones(int[][] stones) {
        checkArray = new boolean[stones.length];
        int res = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!checkArray[i]) {
                res++;
                dfs(stones, i);
            }
        }
        return stones.length - res;
    }

    public void dfs(int[][] stones, int index) {
        checkArray[index] = true;
        for (int i = 0; i < stones.length; i++) {
            if (!checkArray[i] &&
                    (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, i);
            }
        }
    }
}
