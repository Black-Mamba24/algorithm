package sort;

/**
 * Created by zhaiyi on 2018/8/12.
 */
public class SortUtil {
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static boolean check(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                SortUtil.printArray(array);
                return false;
            }
        }
        return true;
    }
}
