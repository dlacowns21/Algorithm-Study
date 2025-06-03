package class4;

import java.io.*;
import java.util.*;

public class Boj_11054_가장긴바이토닉부분수열 {

    static int N;
    static int[] A;
    static int[] LIS;
    static int[] LDS;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        LIS = new int[N];
        LDS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N; i++){
            LIS[i] = 1;
            for(int j = 0; j < i; j++){
                if(A[j] < A[i]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        for(int i = N - 1; i >= 0; i--){
            LDS[i] = 1;
            for(int j = N - 1; j > i; j--){
                if(A[j] < A[i]){
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, LIS[i] + LDS[i] - 1);
        }

        System.out.println(max);
    }
}
