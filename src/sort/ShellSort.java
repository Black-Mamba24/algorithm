package sort;

import java.util.Random;

/**
 * 利用当序列接近顺序时插入排序效率高的特性。先使用较大步长，对序列中间隔为步长的元素序列进行粗略排序，逐渐缩短步长。粗略排序使得序列接近有序。
 * Created by zhaiyi on 2018/8/12.
 */
public class ShellSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(100);
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(100);
            }
            shellSort(array);
            System.out.println(SortUtil.check(array));
        }
    }

    public static void shellSort(int[] array) {
        int length = array.length;
        int gap = length / 2;
        while (gap >= 1) {
            for (int i = 0; i < gap; i++) {
                insertSort(array, i, gap);
            }
            gap = gap / 2;
        }
    }

    private static void insertSort(int[] array, int start, int gap) {
        for (int i = start + gap; i < array.length; i += gap) {
            int tmp = array[i];
            int j = i - gap;
            while (j >= start && array[j] > tmp) {
                array[j + gap] = array[j];
                array[j] = tmp;
                j -= gap;
            }
        }
    }
}
