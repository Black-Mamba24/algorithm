package leetcode.besection.array;

/**
 * 峰值元素是指其值大于左右相邻值的元素。

 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

 你可以假设 nums[-1] = nums[n] = -∞。

 示例 1:

 输入: nums = [1,2,3,1]
 输出: 2
 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 要求：你的解法应该是 O(logN) 时间复杂度的。

 思路：此题使用二分法可能遇到数组越界或死循环问题，有两个技巧可以避免这些问题，也是二分法中通用的技巧。
 1. 避免数组越界，如果是奇数个，mid正好是中间，如果是偶数个，mid是中间靠前一个，因此mid+1不会越界，mid - 1可能越界
 2. 死循环问题，注意mid移动时加减一的问题，是否需要排除mid节点，根据题意判断。此题中两种情况不同，当nums[mid] < nums[mid + 1]时可以排除mid，但nums[mid] > nums[mid + 1]不能排除
 * Created by zhaiyi on 2018/9/14.
 */
public class ArrayPeek {
    public static void main(String[] args) {
        ArrayPeek arrayPeek = new ArrayPeek();
        System.out.println(arrayPeek.findPeakElement(new int[] {1,2,3,4}));
    }
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (l == r)
                return l;
            int mid = (l + r) / 2;
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }
        }
        return 0;
    }
}
