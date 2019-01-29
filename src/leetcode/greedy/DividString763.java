package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class DividString763 {
    public static void main(String[] args) {
        DividString763 dividString763 = new DividString763();
        System.out.println(dividString763.partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String S) {
        int i = 0, j = S.length() - 1;
        List<Integer> res = new ArrayList<>();
        while (i < S.length()) {
            char c = S.charAt(i);
            while (j >= i && S.charAt(j) != c) {
                j--;
            }
            res.add(j - i + 1);
            i = j + 1;
            j = S.length() - 1;
        }
        return res;
    }
}
