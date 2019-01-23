package leetcode.array_string.double_pointer;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class ColorSort75 {
    public static void main(String[] args) {
        ColorSort75 colorSort75 = new ColorSort75();
        int[] color = new int[] {2, 1,0};
        colorSort75.sortColors(color);
        for (int c : color) {
            System.out.print(c + ",");
        }
    }

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[r] == 2) {
                r--;
            }
            while (l < r && nums[l] != 2) {
                l++;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        l = 0;
        while (l < r) {
            while (l < r && nums[r] == 1) {
                r--;
            }
            while (l < r && nums[l] != 1) {
                l++;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
