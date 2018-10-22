package leetcode.bit;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * Created by zhaiyi on 2018/10/15.
 */
public class HangMingDistance461 {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += tmp & 0x01;
            tmp >>= 1;
        }
        return res;
    }
}
