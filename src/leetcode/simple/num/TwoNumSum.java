package leetcode.simple.num;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 输入目标值，数组长度和数组
 * 输出和为目标值的两个数的下标
 * 这是一道简单问题，可以用double for循环解决，但查找效率低，使用map将查找效率降为O(1)
 * Created by zhaiyi on 2018/8/24.
 */
public class TwoNumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            if (map.containsKey(target - array[i])) {
                System.out.println("[" + i + ", " + map.get(target - array[i]) + "]");
            } else {
                map.put(array[i], i);
            }
        }

    }
}
