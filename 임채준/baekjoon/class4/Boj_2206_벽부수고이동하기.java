package class4;

import java.io.*;
import java.util.*;

public class Boj_2206_벽부수고이동하기 {

    static int N, M, ans = -1;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        bfs();

        System.out.println(ans);
    }

    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            int broken = cur[3];

            if (r == N - 1 && c == M - 1) {
                ans = cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!check(nr, nc)) continue;

                if (map[nr][nc] == 0 && !visited[nr][nc][broken]) {
                    visited[nr][nc][broken] = true;
                    que.offer(new int[]{nr, nc, cnt + 1, broken});
                }

                if (map[nr][nc] == 1 && broken == 0 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    que.offer(new int[]{nr, nc, cnt + 1, 1});
                }
            }
        }
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
