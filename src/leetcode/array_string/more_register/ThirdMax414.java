package leetcode.array_string.more_register;

/**
 * 找出非空数组中第三大值
 *
 * 思路：小技巧，用3个变量可以解决，但发现赋初值是有问题，无法将初值赋值为nums[0]也不能是任何int值，但可以设置为Long.MIN_VALUE。
 * Created by zhaiyi on 2018/9/11.
 */
public class ThirdMax414 {
    public static void main(String[] args) {
        ThirdMax414 thirdMax414 = new ThirdMax414();
        System.out.println(thirdMax414.thirdMax(new int[]{1,2,3,4,5,6}));
    }

    public int thirdMax(int[] nums) {

        long first, second, third;
        first = second = third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
