package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 要求空间复杂度为O(n)
 * Created by zhaiyi on 2018/8/30.
 */
public class YangHui2 {
    public static void main(String[] args) {
        YangHui2 yangHui2 = new YangHui2();
        yangHui2.getRow(3);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = null;
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            if (i == 0) {
                current.add(1);
            } else {
                for (int j = 0; j < i + 1; j ++) {
                    int val = 0;
                    if (j - 1 >= 0 && j <= last.size() - 1) {
                        val = last.get(j - 1) + last.get(j);
                    } else if (j -1 < 0) {
                        val = last.get(j);
                    } else if (j > last.size() - 1) {
                        val = last.get(j - 1);
                    }
                    current.add(val);
                }
            }
            last = current;
        }
        return last;
    }
}
