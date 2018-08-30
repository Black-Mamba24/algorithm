package leetcode.simple.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角规律：
 * 1. 每一行的和 = 2 ^ (n-1)
 * 2. 数组排列为(x + y) ^ (n-1)的系数
 * Created by zhaiyi on 2018/8/30.
 */
public class YangHui {
    public static void main(String[] args) {
        YangHui yangHui = new YangHui();
        yangHui.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> last = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
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
                    list.add(val);
                }
            }
            result.add(list);
            last = list;
        }
        return result;
    }
}
