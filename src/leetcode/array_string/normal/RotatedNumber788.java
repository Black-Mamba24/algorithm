package leetcode.array_string.normal;

import java.util.HashSet;
import java.util.Set;

public class RotatedNumber788 {
    public static void main(String[] args) {
        RotatedNumber788 rotatedNumber788 = new RotatedNumber788();
        System.out.println(rotatedNumber788.rotatedDigits(857));
    }
    public int rotatedDigits(int N) {
        Set<Integer> two = new HashSet<>();
        two.add(2);
        two.add(5);
        two.add(6);
        two.add(9);
        Set<Integer> one = new HashSet<>();
        one.add(0);
        one.add(1);
        one.add(8);
        int res = 0;
        for (int i = 2; i <= N; i++) {
            int tmp = i;
            int score = 0;
            int count = 0;
            while (tmp > 0) {
                count++;
                int last = tmp % 10;
                if (two.contains(last)) {
                    score += 2;
                } else if (one.contains(last)) {
                    score += 1;
                } else {
                    break;
                }
                tmp /= 10;
            }
            if (tmp == 0 && score > count) {
                System.out.println(i);
                res++;
            }
        }
        return res;
    }
}
