package leetcode.array_string.double_pointer;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：与头尾双指针思路不同，两个条件可以联想到双指针，一是原地，二是删除，一般删除链表中元素使用pre和cur指针。此题一个指针用于构建新数组，一个指针遍历老数组
 * Created by zhaiyi on 2018/8/24.
 */
public class DeleteItem {
    public static void main(String[] args) {
        DeleteItem deleteItem = new DeleteItem();
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int len = deleteItem.removeElement(array, 2);
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
