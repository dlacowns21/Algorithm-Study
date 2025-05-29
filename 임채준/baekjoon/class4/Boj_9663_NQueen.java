package class4;

import java.io.*;

public class Boj_9663_NQueen {

    static int N;
    static int[] queens;
    static int count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queens = new int[N];

        cal(0);
        System.out.println(count);
    }

    static void cal(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            queens[row] = col;
            if (check(row)) {
                cal(row + 1);
            }
        }
    }

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[i] - queens[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
