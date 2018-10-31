package leetcode.array_string.double_pointer;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Created by zhaiyi on 2018/10/24.
 */
public class ThreeNumSum15 {
    public static void main(String[] args) {
        ThreeNumSum15 threeNumSum15 = new ThreeNumSum15();
        List<List<Integer>> res = threeNumSum15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> negs = new ArrayList<>();
        List<Integer> poss = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (key < 0) {
                negs.add(key);
            } else if (key >= 0) {
                poss.add(key);
            }
        }
        if (map.containsKey(0) && map.get(0) >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);
        }


        for (Integer neg : negs) {
            for (Integer pos : poss) {
                int target = -neg - pos;
                if (map.containsKey(target)) {
                    boolean flag = true;
                    if ((target == neg || target == pos) && map.get(target) == 1) {
                        flag = false;
                    } else if (target > neg && target < pos) {
                        flag = false;
                    }
                    if (flag) {
                        List<Integer> list = new ArrayList<>();
                        list.add(neg);
                        list.add(target);
                        list.add(pos);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return resultList;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int value = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int num = nums[left] + nums[right];
                if (num == value) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);

                    left++;
                    right--;

                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }

                } else if (num < value) {
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }
            }
            while (i + 1 < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return resultList;
    }

}
