package leetcode.array_string.normal;

import java.util.HashSet;
import java.util.Set;

public class ErrorSet645 {
    public static void main(String[] args) {
        ErrorSet645 errorSet645 = new ErrorSet645();
        int[] res = errorSet645.findErrorNums(new int[] {1, 2, 2, 4});
        System.out.println(res[0] + "  " + res[1]);
    }

    /**
     * hashset法
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int total = (1 + nums.length) * nums.length / 2;
        int sum = 0;
        int dul = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(num)) {
                dul = num;
            } else {
                set.add(num);
            }
        }
        int[] res = new int[2];
        res[0] = dul;
        res[1] = total - sum + dul;
        return res;
    }

    /**
     * 最优解，对号入座
     * @param nums
     * @return
     */
    public int[] findErrorNums2(int[] nums) {
        int[] cont = new int[nums.length];
        int loss = 0;
        int repeat = 0;
        for (int i = 0; i < nums.length; i++) {
            cont[nums[i]-1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cont[i] == 0) {
                loss = i + 1;
            }
            if (cont[i] == 2) {
                repeat = i + 1;
            }
        }
        int[] res = new int[2];
        res[0] = repeat;
        res[1] = loss;
        return res;
    }
}
