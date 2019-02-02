package leetcode.array_string.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumSpecialEquivGroups893 {
    public static void main(String[] args) {
        NumSpecialEquivGroups893 numSpecialEquivGroups893 = new NumSpecialEquivGroups893();
        System.out.println(numSpecialEquivGroups893.numSpecialEquivGroups(new String[] {"ababaa","aaabaa"}));
    }

    public int numSpecialEquivGroups(String[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (b[i] == -1) {
                b[i] = i;
                for (int j = i + 1; j < A.length; j++) {
                    String x = A[i];
                    String y = A[j];
                    if (x.length() != y.length()) {
                        continue;
                    }
                    if (x.equals(y)) {
                        b[j] = i;
                        continue;
                    }
                    boolean[] check_x = new boolean[x.length()];
                    boolean[] check_y = new boolean[y.length()];
                    for (int k = 0; k < x.length(); k++) {
                        if (!check_x[k]) {
                            if (k % 2 == 0) {
                                for (int l = 0; l < y.length(); l += 2) {
                                    if (!check_y[l]) {
                                        if (x.charAt(k) == y.charAt(l)) {
                                            check_x[k] = check_y[l] = true;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                for (int l = 1; l < y.length(); l += 2) {
                                    if (!check_y[l]) {
                                        if (x.charAt(k) == y.charAt(l)) {
                                            check_x[k] = check_y[l] = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    boolean flag = true;
                    for (boolean c : check_x) {
                        if (!c) {
                            flag = false;
                            break;
                        }
                    }
                    for (boolean c : check_y) {
                        if (!c) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        b[j] = i;
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int aB : b) {
            set.add(aB);
        }
        return set.size();
    }

}