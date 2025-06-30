package class5;

import java.io.*;
import java.util.*;

public class Boj_2166_다각형의면적 {
    
    static int N;
    static long[] x, y;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        x = new long[N];
        y = new long[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        
        double area = 0;

        for (int i = 0; i < N; i++) {
            area += x[i] * y[(i + 1) % N];
            area -= y[i] * x[(i + 1) % N];
        }
        
        area = Math.abs(area) / 2.0;

        System.out.printf("%.1f\n", area);
    }
}
