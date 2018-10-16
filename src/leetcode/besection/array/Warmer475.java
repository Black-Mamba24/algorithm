package leetcode.besection.array;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。

 说明:
 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 所有供暖器都遵循你的半径标准，加热的半径也一样。
 示例 1:

 输入: [1,2,3],[2]
 输出: 1
 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 示例 2:

 输入: [1,2,3,4],[1,4]
 输出: 1
 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。

 思路：首先取暖器可能小于最小房子，大于最大房子，要注意。经过思考后发现只需要找每个房子最近的取暖器距离，所有房子的最小距离取最大值。
 因此变成为一道查找题目，示例中是有序的，因此想到二分查找。但需要注意二分查找到的取暖器不一定是最近的，也可能是该取暖器左边或右边的取暖器更近。
 * Created by zhaiyi on 2018/10/10.
 */
public class Warmer475 {
    public static void main(String[] args) {
        Warmer475 warmer475 = new Warmer475();
        System.out.println(warmer475.findRadius(new int[]{1,2,3,4}, new int[]{1,6}));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            int left = 0, right = heaters.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (heaters[mid] > house) {
                    right = mid - 1;
                } else if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    left = right = mid;
                }
            }
            int tmp = 0;
            if (heaters[left] < house) {
                tmp = Math.abs(heaters[left] - house);
                if (left + 1 < heaters.length) {
                    tmp = Math.min(tmp, Math.abs(heaters[left + 1] - house));
                }
            } else if (heaters[left] > house) {
                tmp = Math.abs(heaters[left] - house);
                if (left - 1 >= 0) {
                    tmp = Math.min(tmp, Math.abs(heaters[left - 1] - house));
                }
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
