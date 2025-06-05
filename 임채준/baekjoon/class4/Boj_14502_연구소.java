package class4;

import java.io.*;
import java.util.*;

public class Boj_14502_연구소 {

    static int N, M, max = 0;
    static int[][] map;
    static int[][] temp;
    static List<int[]> virus = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        build(0);
        System.out.println(max);
    }

    static void build(int count) {
        if (count == 3) {
            spread();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    build(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void spread() {
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }

        Queue<int[]> que = new LinkedList<>();
        for (int[] v : virus) {
            que.offer(new int[]{v[0], v[1]});
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (check(nr, nc)) {
                    if (temp[nr][nc] == 0) {
                        temp[nr][nc] = 2;
                        que.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        count();
    }

    static void count() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safe++;
                }
            }
        }
        max = Math.max(max, safe);
    }
    
    static boolean check(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < M;
    }
}
