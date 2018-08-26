package leetcode.simple;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * Created by zhaiyi on 2018/8/24.
 */
public class DeleteRepeatItem {
    public static void main(String[] args) {
        DeleteRepeatItem deleteRepeatItem = new DeleteRepeatItem();
        int[] array = new int[]{1,1,2,3,3,4,4,5,6,7,8};
        int len = deleteRepeatItem.removeDuplicates(array);
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public int removeDuplicates(int[] nums) {
//        int j = 0, i = 0;
//        while(i < nums.length) {
//            while(i + 1 < nums.length && nums[i] == nums[i+1]) {
//                i++;
//            }
//            nums[j++] = nums[i++];
//        }
//        return j;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+ 1;
    }
}
