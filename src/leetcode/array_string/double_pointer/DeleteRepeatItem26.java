package leetcode.array_string.double_pointer;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 思路："原地"+"删除"联想双指针法，一个指针构建新数组，一个指针遍历老数组，注意构建新数组时要先移动指针
 * 注意创建新数组（覆盖）时要先移动指针
 * Created by zhaiyi on 2018/8/24.
 */
public class DeleteRepeatItem26 {
    public static void main(String[] args) {
        DeleteRepeatItem26 deleteRepeatItem26 = new DeleteRepeatItem26();
        int[] array = new int[]{1,1,2,3,3,4,4,5,6,7,8};
        int len = deleteRepeatItem26.removeDuplicates(array);
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+ 1;
    }
}
