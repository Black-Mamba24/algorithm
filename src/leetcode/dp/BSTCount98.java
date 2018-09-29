package leetcode.dp;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

 示例:

 输入: 3
 输出: 5
 解释:
 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 思路：第一点想到要根据start，end递归，递归[start， i - 1]；[i + 1， end]，当差值为0，1，2时能快速得出结果，但导致代码逻辑复杂，且时间长
 接着想解决时间长的问题，发现子树节点数量相同，能组成的子树数量相同，因此在map中存储end - start对应的子树个数，但还是用了思路一的方法，没考虑到左子树 * 右子树
 此题两个特点能判定为动态规划：1. n + 1的子树结果跟1 ~ n的结果相关  2. 备忘录法。
 * Created by zhaiyi on 2018/9/19.
 */
public class BSTCount98 {
    public static void main(String[] args) {
        BSTCount98 BSTCount98 = new BSTCount98();
        System.out.println(BSTCount98.numTrees(4));
    }

    public int numTrees(int n) {
        if (n <= 1) {
            return n;
        }
        int[] treeNums = new int[n + 1];
        treeNums[0] = 1;
        treeNums[1] = 1;
        //以i为头结点，结果为左子树个数 * 右子树个数
        //treeNums表示i个子树节点组成的二叉搜索树的个数，特殊的是treeNums[0]，表示没有子树，不能为0。
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                treeNums[i] += (treeNums[j] * treeNums[i - 1 - j]);
            }
        }
        return treeNums[n];
    }
}
