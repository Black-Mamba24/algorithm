package leetcode.besection.array;

import java.util.ArrayList;
import java.util.List;

public class RecentCall933 {
    public List<Integer> list = new ArrayList<>();

    public RecentCall933() {

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
