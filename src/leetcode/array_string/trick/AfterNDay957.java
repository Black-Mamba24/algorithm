package leetcode.array_string.trick;

/**
 * N 天后的牢房
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 *
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 *
 * 思路：不要质疑规则，不要认为可以改变规则达到节省时间。
 * 积累经验吧，有重复性规律，没做出来
 */
public class AfterNDay957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N %= 14;
        if (N == 0) {
            N = 14;
        }
        for (int i = 0; i < N; i++) {
            int[] new_cells = new int[8];
            new_cells[0] = 0;
            new_cells[7] = 0;
            for (int j = 1; j < 7; j++) {
                new_cells[j] = 1 - cells[j - 1] ^ cells[j + 1];
            }
            cells = new_cells;
        }
        return cells;
    }
}
