package leetcode.array_string.more_register;

/**
 * Created by zhaiyi on 2018/9/16.
 */
public class Fruit908 {
    public static void main(String[] args) {
        Fruit908 fruit908 = new Fruit908();
        System.out.println(fruit908.totalFruit(new int[]{0}));
    }

    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        long b1 = tree[0], b2 = Long.MAX_VALUE;
        int count = 1, max = 1;
        for (int i = 1; i < tree.length; i++) {
            if (b2 == Long.MAX_VALUE) {
                if (tree[i] == b1) {
                    count ++;
                } else {
                    count ++;
                    b2 = tree[i];
                }
                max = Math.max(max, count);
            } else if (tree[i] == b1 || tree[i] == b2) {
                if (b1 == tree[i]) {
                    long tmp = b2;
                    b2 = b1;
                    b1 = tmp;
                }
                count ++;
                max = Math.max(max, count);
            } else {
                int c = 0, tmp = i - 1, v = tree[tmp];
                while(tmp >= 0 && tree[tmp] == v) {
                    tmp--;
                    c++;
                }
                count = 1 + c;
                b1 = b2;
                b2 = tree[i];
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
