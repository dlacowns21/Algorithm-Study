package class4;

import java.io.*;
import java.util.*;

public class Boj_12851_숨바꼭질2 {
    
    static int N, K;
    static int[] time, count;
    static final int MAX = 100001;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        time = new int[MAX];
        count = new int[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 1; 
        count[N] = 1;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : new int[] {now - 1, now + 1, now * 2}) {
                if (next < 0 || next >= MAX) continue;

                if (time[next] == 0) {
                    time[next] = time[now] + 1;
                    count[next] = count[now];
                    queue.offer(next);
                }
                
                else if (time[next] == time[now] + 1) {
                    count[next] += count[now];
                }
            }
        }

        System.out.println(time[K] - 1); 
        System.out.println(count[K]);
    }
}
