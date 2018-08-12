package sort;

import java.util.Random;

/**
 * Created by zhaiyi on 2018/8/12.
 */
public class SelectSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(100);
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(100);
            }
            selectSort(array);
            System.out.println(SortUtil.check(array));
        }
    }

    public static void selectSort(int[] array) {
        //从后面序列中找到最小值，放到队首
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int min_index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_index = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min_index];
            array[min_index] = tmp;
        }
    }

}
