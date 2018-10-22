package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 *
 * 注意类似4、41组合，本题思路为按特定顺序排序，当判断o1、o2顺序时应将他们拼接后比较
 * Created by zhaiyi on 2018/8/19.
 */
public class NumberString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt() + "";
        }
        Arrays.sort(array, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        for (int i = count - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
        System.out.println();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }
}

