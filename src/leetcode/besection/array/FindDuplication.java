package leetcode.besection.array;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

 示例 1:

 输入: [1,3,4,2,2]
 输出: 2
 示例 2:

 输入: [3,1,3,4,2]
 输出: 3
 说明：

 不能更改原数组（假设数组是只读的）。
 只能使用额外的 O(1) 的空间。
 时间复杂度小于 O(n^2) 。
 数组中只有一个重复的数字，但它可能不止重复出现一次。

 思路：首先想到排序，用快排+遍历可以通过，第二种方法用二分查找，普通二分查找变种，两个指针不是指向数组下标，而是代表具体的值。
 * Created by zhaiyi on 2018/9/13.
 */
public class FindDuplication {
    public static void main(String[] args) {
        FindDuplication findDuplication = new FindDuplication();
        findDuplication.findDuplicate(new int[] {1,3,4,2,2});
    }
    public int findDuplicate(int[] nums) {
        //l代表最小值，合理利用数字都在1-n，如果长度为n，其中还包含至少一个重复元素，因此数组中最大值为n - 1
        //先找中间数值，判断小于等于中间值的数量，根据数量是否大于中间值判断重复值在左边还是右边
        //这道题很好的利用了1-n的数字特性
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count ++;
                }
            }
            if (count > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
