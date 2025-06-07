package class4;

import java.io.*;
import java.util.*;

public class Boj_2110_공유기설치 {

    static int N, C;
    static int[] house;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[N - 1] - house[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (find(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean find(int d) {
        int count = 1;
        int last = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - last >= d) {
                count++;
                last = house[i];
            }
        }

        return count >= C;
    }
}
