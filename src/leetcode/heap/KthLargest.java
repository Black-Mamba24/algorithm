package leetcode.heap;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

 示例:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 说明:
 你可以假设 nums 的长度≥ k-1 且k ≥ 1。

 思路：
 * Created by zhaiyi on 2018/10/22.
 */
public class KthLargest {
    /* 方法一，笨方法 */
    //大根堆，从第k开始较小的数
    //public PriorityQueue<Integer> q_max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //小跟堆，前k-1个最大的数
    //public PriorityQueue<Integer> q_min = new PriorityQueue<>((o1, o2) -> o1 - o2);

//    public KthLargest(int k, int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            q_min.offer(nums[i]);
//            if (q_min.size() > k - 1) {
//                int tmp = q_min.poll();
//                q_max.offer(tmp);
//            }
//        }
//    }
//
//    public int add(int val) {
//        if (q_max.size() != 0) {
//            if (val > q_max.peek()) {
//                q_min.offer(val);
//                int tmp = q_min.poll();
//                q_max.offer(tmp);
//            } else {
//                q_max.offer(val);
//            }
//        } else {
//            q_min.offer(val);
//            if (q_min.size() > k - 1) {
//                int tmp = q_min.poll();
//                q_max.offer(tmp);
//            }
//        }
//        return q_max.peek();
//    }
    /* 方法一，end */



    /* 方法二：最优解 */
    public int k = 0;
    //小跟堆，只存前k大的数，poll最小值，即第k大的数
    public PriorityQueue<Integer> q_min_2 = new PriorityQueue<>((o1, o2) -> o1 - o2);

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            q_min_2.offer(nums[i]);
            if (q_min_2.size() > k) {
                q_min_2.poll();
            }
        }
    }

    public int add(int val) {
        if (q_min_2.size() < k) {
            q_min_2.offer(val);
        } else if (q_min_2.peek() < val) {
            q_min_2.poll();
            q_min_2.offer(val);
        }
        return q_min_2.peek();
    }
    /* 方法二：end */
}
