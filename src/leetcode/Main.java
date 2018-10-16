package leetcode;

import java.util.*;

/**
 * Created by zhaiyi on 2018/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.champagneTower(6,3,1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glass = new double[query_row + 1][query_row + 1];
        glass[0][0] = poured;
        if (poured == 0) {
            return 0.0;
        } else if (poured == 1) {
            if (query_row == 0 && query_glass == 0) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        for (int i = 1; i < query_row + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    //每行第一个
                    glass[i][j] = (double) (glass[i - 1][j] - 1) / 2;
                } else if (j == i) {
                    //每行最后一个
                    glass[i][j] = (double) (glass[i - 1][j - 1] - 1) / 2;
                } else {
                    if (glass[i - 1][j - 1] > 1) {
                        glass[i][j] += (double) (glass[i - 1][j - 1] - 1) / 2;
                    }
                    if (glass[i - 1][j] > 1) {
                        glass[i][j] += (double) (glass[i - 1][j] - 1) / 2;
                    }
                }
            }
        }
        if (glass[query_row][query_glass] > 1.0) {
            return 1.0;
        } else if (glass[query_row][query_glass] < 0.0) {
            return 0.0;
        } else {
            return glass[query_row][query_glass];
        }
    }

}
