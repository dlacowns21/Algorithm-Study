package class4;

import java.io.*;
import java.util.*;

public class Boj_1967_트리의지름 {

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int n;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int far = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        max = 0;
        dfs(far, 0);

        System.out.println(max);
    }

    static void dfs(int current, int sum) {
        visited[current] = true;

        if (sum > max) {
            max = sum;
            far = current;
        }

        for (Node next : tree[current]) {
            if (!visited[next.to]) {
                dfs(next.to, sum + next.weight);
            }
        }
    }
}
