package leetcode.besection.array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * 最近的请求次数
 * 写一个 RecentCounter 类来计算最近的请求。
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 * 返回从 3000 毫秒前到现在的 ping 数。
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 * 示例：
 *
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 */
public class RecentCounter933 {
    public List<Integer> list = new ArrayList<>();

    public RecentCounter933() {

    }

    /**
     * 二分查找
     * @param t
     * @return
     */
    public int ping(int t) {
        list.add(t);
        int target = t - 3000;
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid;
                break;
            }
        }
        return list.size() - l + 1;
    }
}
