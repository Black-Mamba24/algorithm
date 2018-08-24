package number;

import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 * 计算阶乘中有几个5，其中25包含2个5，125包含3个5，因此每次除5之后，还要继续除5，检查上一批5的倍数中还有哪些是25的倍数
 * Created by zhaiyi on 2018/8/19.
 */
public class FactorialZeroCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        while (num != 0) {
            count += num/5;
            num /=5;
        }
        System.out.println(count);
    }
}
