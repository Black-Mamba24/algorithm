package string;

import java.util.Scanner;

/**
 * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”
 * 这个挺简单的
 * Created by zhaiyi on 2018/8/19.
 */
public class StringReverse {
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
