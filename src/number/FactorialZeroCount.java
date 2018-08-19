package number;

import java.util.Scanner;

/**
 * Created by zhaiyi on 2018/8/19.
 */
public class Main {
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
