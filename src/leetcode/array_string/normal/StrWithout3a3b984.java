package leetcode.array_string.normal;

/**
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 *
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 */
public class StrWithout3a3b984 {
    public static void main(String[] args) {
        StrWithout3a3b984 strWithout3a3b984 = new StrWithout3a3b984();
        int[][] x = new int[][] {
            {1, 2},
            {2, 4},
            {2, 5},
            {4, 2},
            {5, 2},
            {1, 1},
            {4, 1},
            {3, 7},
            {5,8},
            {5,10}
        };
        for (int i = 0; i < x.length; i++) {
            System.out.println(strWithout3a3b984.strWithout3a3b(x[i][0], x[i][1]));
        }

    }

    public String strWithout3a3b(int A, int B) {
        int max = A >= B ? A : B;
        int min = A >= B ? B : A;
        Character maxC = max == A ? 'a' : 'b';
        Character minC = max == A ? 'b' : 'a';
        StringBuilder stringBuilder = new StringBuilder();
        while (max != 0 || min != 0) {
            if (max > 2) {
                max -= 2;
                stringBuilder.append(maxC);
                stringBuilder.append(maxC);
            } else if (max != 0) {
                max--;
                stringBuilder.append(maxC);
            }
            if (min == 1 || (max * 1.0) / (min - 2) >= 2.0) {
                min--;
                stringBuilder.append(minC);
            } else if (min >= 2) {
                min -= 2;
                stringBuilder.append(minC);
                stringBuilder.append(minC);
            }
        }
        return stringBuilder.toString();
    }
}
