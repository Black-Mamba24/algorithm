package leetcode.greedy;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。



 示例 1：

 输入：people = [1,2], limit = 3
 输出：1
 解释：1 艘船载 (1, 2)
 示例 2：

 输入：people = [3,2,2,1], limit = 3
 输出：3
 解释：3 艘船分别载 (1, 2), (2) 和 (3)

 思路:先排序，再用双指针法，贪心问题用到排序的场景多
 * Created by zhaiyi on 2018/9/29.
 */
public class LifeBoat881 {

    public static void main(String[] args) {
        LifeBoat881 lifeBoat881 = new LifeBoat881();
        System.out.println(lifeBoat881.numRescueBoats(new int[]{5, 4, 2, 1}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);
        int l = 0, r = people.length - 1, ans = 0;
        while (people[r] > limit) {
//            ans++;
            r--;
        }
        while (l <= r) {
            if (people[l] + people[r] > limit) {
                ans++;
                r--;
            } else {
                ans++;
                r--;
                l++;
            }
        }
        return ans;
    }
}
