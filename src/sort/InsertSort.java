package sort;

import java.util.Random;

/**
 * Created by zhaiyi on 2018/8/12.
 */
public class InsertSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(100);
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(100);
            }
            insertSort(array);
            System.out.println(SortUtil.check(array));
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                array[j] = tmp;
                j--;
            }
        }
    }

}
