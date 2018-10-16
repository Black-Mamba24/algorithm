package leetcode.array_string.double_pointer;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。

 思路：数组、字符串遇到两个边界的问题，可以联想双指针法。思路是头尾各一个指针，头部向后移动，尾部向前移动，值小的指针移动。
 * Created by zhaiyi on 2018/9/10.
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1, max = 0;
        while (head < tail) {
            int min = Math.min(height[head], height[tail]);
            int area = min * (tail - head);
            max = Math.max(area, max);
            if (height[head] < height[tail]) {
                head ++;
            } else {
                tail --;
            }
        }
        return max;
    }
}
