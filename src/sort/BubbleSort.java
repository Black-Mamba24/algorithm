package sort;

import java.util.Random;

/**
 * Created by zhaiyi on 2018/8/12.
 */
public class BubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(100);
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(100);
            }
            bubbleSort(array);
            System.out.println(SortUtil.check(array));
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

}
