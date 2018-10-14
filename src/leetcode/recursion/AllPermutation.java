package leetcode.recursion;

/**
 * 递归题目一般有三种：
 * 1. 数据按照递归格式定义，例如斐波那契数列
 * 2. 阶梯思路需要递归格式，例如回溯算法
 * 3. 数据结构是递归格式，例如树和图
 * 打印一个列表的全排列
 * 思路：当start == end时打印列表，当start < end时start - end的元素都与start元素交换位置，
 * 再递归计算start+1 - end的全排列，并将结果作为start - end全排列的后缀
 * Created by zhaiyi on 2018/10/12.
 */
public class AllPermutation {
    public static void main(String[] args) {
        AllPermutation allPermutation = new AllPermutation();
        int [] array = new int[]{1,2,3,4};
        allPermutation.print(array, 0, array.length - 1);
    }

    public void print(int[] array, int start, int end) {
        if (start == end) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                print(array, start + 1, end);
                swap(array, start, i);
            }
        }
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
