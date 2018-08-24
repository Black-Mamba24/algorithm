package sort;

import java.util.Random;

/**
 * 选第一个元素作为基准，后面序列，比基准小的放在左边，否则放在右边，以基准值分割成两个子数组，再对子数组递归做相同操作。
 * Created by zhaiyi on 2018/8/19.
 */
public class FastSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(100);
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(100);
            }
            fastSort(array);
            System.out.println(SortUtil.check(array));
        }
    }

    public static void fastSort(int[] array) {
        doFastSort(array, 0, array.length - 1);
    }

    public static void doFastSort(int[] array, int start, int end) {
        if (start < end) {
            int base = array[start];
            int i = start, j = end;
            while (i < j) {
                //从右边开始
                while (i < j && array[j] >= base) {
                    j--;
                }
                while (i < j && array[i] <= base) {
                    i++;
                }

                if (i != j) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                } else {
                    int tmp = array[start];
                    array[start] = array[i];
                    array[i] = tmp;
                }
            }
            doFastSort(array, start, i - 1);
            doFastSort(array, i + 1, end);
        }
    }
}
