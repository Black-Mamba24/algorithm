package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        main3.intervalIntersection(new Interval[] {
            new Interval(0, 2),
            new Interval(5, 10),
            new Interval(13,23),
            new Interval(24,25)
        }, new Interval[] {new Interval(1,5),
        new Interval(8,12),
        new Interval(15,24),
        new Interval(25,26)});
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int a = 0, b = 0;
        List<Interval> list = new ArrayList<>();
        while (a != A.length && b != B.length) {
            if (A[a].start <= B[b].end && B[b].start <= A[a].end) {
                int start = Math.max(A[a].start, B[b].start);
                int end = Math.min(A[a].end, B[b].end);
                list.add(new Interval(start, end));
            }
            if (A[a].end > B[b].end) {
                b++;
            } else if (A[a].end < B[b].end) {
                a++;
            } else {
                a++;
                b++;
            }
        }
        Interval[] res = new Interval[list.size()];
        int i = 0;
        for (Interval interval : list) {
            res[i++] = interval;
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
