package leetcode.bit;

import java.util.Arrays;

public class SingleNumberIII260 {
    public static void main(String[] args) {
        SingleNumberIII260 singleNumberIII260 = new SingleNumberIII260();
        int[] res = singleNumberIII260.singleNumber(new int[] {1,2,1,3,2,5});
        System.out.println(res[0] + "  " + res[1]);
    }

    public int[] singleNumber(int[] nums) {
        int res1 = 0, res2 = 0, x = 0;
        Arrays.sort(nums);
        for (int n : nums) {
            x ^= n;
        }
        for (int n : nums) {
            x ^= n;
            if (x == 0) {
                res1 = n;
                break;
            }
        }
        for (int n : nums) {
            if (n != res1) {
                res2 ^= n;
            }
        }
        return new int[] {res1, res2};
    }
}
