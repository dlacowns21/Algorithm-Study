package class4;

import java.io.*;
import java.util.*;

public class Boj_1238_파티 {

    static int N, M, X;
    static List<List<Node>> graph;
    static List<List<Node>> rgraph;
    static final int INF = Integer.MAX_VALUE;

    // PriorityQueue를 사용하기 위해 Comparable을 구현한 Node 클래스 정의
    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        // PriorityQueue에서 cost 기준으로 정렬되도록 설정
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        rgraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            rgraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, time));
            rgraph.get(to).add(new Node(from, time));
        }

        int[] toX = dijkstra(rgraph, X);
        int[] fromX = dijkstra(graph, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }

        System.out.println(max);
    }

    // 다익스트라: 하나의 정점에서 모든 정점까지의 최단 거리를 알 수 있음
    // 플로이드워셜:모든 정점에서 모든 정점까지의 최단 거리를 알 수 있음
    static int[] dijkstra(List<List<Node>> g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Node next : g.get(cur.to)) {
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }
}
