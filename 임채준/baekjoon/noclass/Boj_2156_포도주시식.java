package noclass;

import java.io.*;

public class Boj_2156_포도주시식 {

    static int n;
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wine = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                        Math.max(dp[i - 2] + wine[i],
                                 dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[n]);
    }
}
