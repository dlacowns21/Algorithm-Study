package class4;

import java.io.*;
import java.util.*;

public class Boj_10830_행렬제곱 {

    static int N;
    static long B;
    static int[][] A;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int val : row) {
                sb.append(val % MOD).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[][] power(int[][] matrix, long exp) {
        if (exp == 1L) {
            return matrix;
        }

        int[][] half = power(matrix, exp / 2);
        int[][] temp = mul(half, half);

        if (exp % 2 == 1) {
            return mul(temp, A);
        } else {
            return temp;
        }
    }

    static int[][] mul(int[][] m1, int[][] m2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (m1[i][k] * m2[k][j]) % MOD;
                }
                result[i][j] = sum % MOD;
            }
        }

        return result;
    }
}
