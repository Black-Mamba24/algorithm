package leetcode;

import java.util.PriorityQueue;

/**
 * Created by zhaiyi on 2018/10/19.
 */
public class Main {
    public PriorityQueue<Integer> q_max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public PriorityQueue<Integer> q_min = new PriorityQueue<>((o1, o2) -> o1 - o2);
    public int k = 0;

    public static void main(String[] args) {
        Main main = new Main(3, new int[]{4,5,8,2});
        main.add(3);
        main.add(5);
        main.add(10);
        main.add(9);
        main.add(4);
    }

    public Main(int k, int[] nums) {
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                q_max.offer(nums[i]);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    q_max.offer(nums[i]);
                } else {
                    q_max.offer(nums[i]);
                    int n = q_max.poll();
                    q_min.offer(n);
                }
            }
        }

        this.k = k;
    }

    public int add(int val) {
        if (k == 1) {
            q_max.offer(val);
            return q_max.peek();
        } else {
            q_max.offer(val);
            if (q_max.size() > k - 1) {
                int n = q_max.poll();
                q_min.offer(n);
                System.out.println(q_min.peek());
                return q_min.peek();
            } else {
                return 0;
            }
        }

    }
}
