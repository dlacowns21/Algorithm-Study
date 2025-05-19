package class4;

import java.io.*;
import java.util.*;

public class Boj_1987_알파벳 {

    static int R, C, max = 0;
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int r, int c, int cnt) {
        visited[map[r][c] - 'A'] = true;
        max = Math.max(max, cnt);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (check(nr, nc)) {
                int index = map[nr][nc] - 'A';
                if (!visited[index]) {
                    dfs(nr, nc, cnt + 1);
                }
            }
        }

        visited[map[r][c] - 'A'] = false;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
