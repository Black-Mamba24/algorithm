package sort;

import java.util.Random;

/**
 * 归并=递归+合并，分治算法。
 * 递归到每个序列只有一个元素
 * 合并时合并两个有序列表
 * Created by zhaiyi on 2018/8/19.
 */
public class MergeSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(100);
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(100);
            }
            mergeSort(array, 0, array.length - 1);
            System.out.println(SortUtil.check(array));
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, end);
        }
    }

    /**
     * 合并两个有序列表
     * @param array
     * @param start
     * @param end
     */
    public static void merge(int[] array, int start, int end) {
        int[] tmp_array = new int[end - start + 1];
        int mid = (start + end) / 2;
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                tmp_array[k++] = array[i++];
            } else {
                tmp_array[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tmp_array[k++] = array[i++];
        }
        while (j <= end) {
            tmp_array[k++] = array[j++];
        }
        i = 0;
        while (i < k) {
            array[start++] = tmp_array[i++];
        }
    }
}
