import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaiyi on 2019/1/6.
 */
public class MergeTwoArray {
    /**
     * a, b有序数组
     *
     * @param a
     * @param b
     * @return 返回合并后的数组
     */
    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        if (i < a.length) {
            System.arraycopy(a, i, c, k, a.length - i);
        }

        if (j < b.length) {
            System.arraycopy(b, j, c, k, b.length - j);
        }
        return c;
    }

    public static void main(String[] args) {
        Map<int[], int[]> cases = new HashMap<>();
        cases.put(new int[] {1, 3, 5}, new int[] {2, 4, 6});
        cases.put(new int[] {}, new int[] {2, 4, 6});
        cases.put(new int[] {1}, new int[] {2, 4, 6});
        cases.put(new int[] {1, 3, 5, 7, 9}, new int[] {2, 4, 6});
        cases.put(new int[] {1}, new int[] {2});
        cases.put(new int[] {-3, -1, 0}, new int[] {-2, 4, 6});
        cases.put(new int[] {}, new int[] {});
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        for (Map.Entry<int[], int[]> entry : cases.entrySet()) {
            int[] c = mergeTwoArray.merge(entry.getKey(), entry.getValue());
            int i = 1;
            while (i < c.length) {
                if (c[i - 1] > c[i]) {
                    System.out.println(false);
                }
                i++;
            }
            System.out.println(true);
        }
    }
}
