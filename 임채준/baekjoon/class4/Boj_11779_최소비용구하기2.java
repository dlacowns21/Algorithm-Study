package class4;

import java.io.*;
import java.util.*;

public class Boj_11779_최소비용구하기2 {
    
    static int n, m;
    static List<List<Node>> graph;
    static int[] dist;
    static int[] parent;
    
    static class Node implements Comparable<Node> {
        int to, cost;
        
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Node(to, cost));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        List<Integer> path = new ArrayList<>();
        int current = end;
        while (current != 0) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);
        
        System.out.println(dist[end]);
        System.out.println(path.size());
        
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.to;
            int curCost = cur.cost;
            
            if (curCost > dist[curNode]) {
                continue;
            }

            for (Node next : graph.get(curNode)) {
                int nextNode = next.to;
                int nextCost = curCost + next.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    parent[nextNode] = curNode;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }
    }
}