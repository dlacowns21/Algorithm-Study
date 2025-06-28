package class4;

import java.io.*;
import java.util.*;

public class Boj_16236_아기상어 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int time = 0;
    static int size = 2;
    static int eat = 0;

    static class Shark {
        int r, c;

        Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Fish implements Comparable<Fish> {
        int r, c, dist;

        Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.r == o.r) {
                    return this.c - o.c;
                }
                return this.r - o.r;
            }
            return this.dist - o.dist;
        }
    }

    static Shark shark;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs();
            if (target == null) break;

            shark.r = target.r;
            shark.c = target.c;

            time += target.dist;
            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }

            map[target.r][target.c] = 0;
        }

        System.out.println(time);
    }

    static Fish bfs() {
        Queue<int[]> que = new LinkedList<>();
        visited = new boolean[N][N];
        que.offer(new int[]{shark.r, shark.c, 0});
        visited[shark.r][shark.c] = true;

        List<Fish> candidates = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (dist > minDist) break;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (check(nr, nc)) {
                    if (map[nr][nc] <= size) {
                        visited[nr][nc] = true;
                        if (map[nr][nc] > 0 && map[nr][nc] < size) {
                            candidates.add(new Fish(nr, nc, dist + 1));
                            minDist = dist + 1;
                        }
                        que.offer(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }

        if (candidates.isEmpty()) return null;

        Collections.sort(candidates);
        return candidates.get(0);
    }
    
    public static boolean check(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < N && !visited[r][c];
    }
}
