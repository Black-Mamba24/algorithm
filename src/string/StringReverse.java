package string;

import java.util.Scanner;

/**
 * Created by zhaiyi on 2018/8/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] words = string.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(words[i] + " ");
            } else {
                System.out.print(words[i]);
            }
        }
    }
}
