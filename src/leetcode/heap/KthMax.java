package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthMax {

    private int m;
    Queue<Integer> queue=new PriorityQueue<Integer>();

    public KthMax(int k, int[] nums) {
        m=k;
        for(int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        while((queue.size()-m)>0){
            queue.poll();
        }
        return queue.peek();
    }
}
