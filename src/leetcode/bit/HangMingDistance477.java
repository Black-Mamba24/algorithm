package leetcode.bit;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

 计算一个数组中，任意两个数之间汉明距离的总和。

 示例:

 输入: 4, 14, 2

 输出: 6

 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 所以答案为：
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 注意:

 数组中元素的范围为从 0到 10^9。
 数组的长度不超过 10^4。

 思路：如果按照汉明距离的计算方法，时间复杂度为O(n ^ 2)。此题要变换思路：
 每个数字比较相同位置上的值，对于相同的值来说距离为0，可以理解为每个数值为1的数字都要与所有数值为0的数计算距离，即1的数量 * 0的数量
 对所有位都按此方法计算，累加距离。
 * Created by zhaiyi on 2018/10/19.
 */
public class HangMingDistance477 {
    public static void main(String[] args) {
        HangMingDistance477 hangMingDistance477 = new HangMingDistance477();
        System.out.println(hangMingDistance477.totalHammingDistance(new int[] {4,14,2}));
    }

    public int totalHammingDistance(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0; //所有数末位为1的数量
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                count += (num & 1);
                num >>= 1;
                nums[j] = num;
            }
            res += count * (nums.length - count);
        }
        return res;
    }
}
