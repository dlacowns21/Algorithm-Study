package src.sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_징검다리 {

    static int n, max;
    static int[] map, dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(map[j] < map[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
