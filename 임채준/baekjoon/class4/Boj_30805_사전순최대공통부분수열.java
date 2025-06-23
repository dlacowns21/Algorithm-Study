package class4;

import java.io.*;
import java.util.*;

public class Boj_30805_사전순최대공통부분수열 {
    
    static int N, M;
    static int[] A, B;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> result = solve(0, 0);
        
        System.out.println(result.size());
        if (result.size() > 0) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    static List<Integer> solve(int startA, int startB) {
    	
        int maxCommon = -1;
        int posA = -1, posB = -1;

        for (int i = startA; i < N; i++) {
            for (int j = startB; j < M; j++) {
                if (A[i] == B[j] && A[i] > maxCommon) {
                    maxCommon = A[i];
                    posA = i;
                    posB = j;
                }
            }
        }
        
        if (maxCommon == -1) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(maxCommon);

        List<Integer> remain = solve(posA + 1, posB + 1);
        result.addAll(remain);
        
        return result;
    }
}