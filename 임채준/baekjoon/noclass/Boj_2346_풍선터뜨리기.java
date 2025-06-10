package noclass;

import java.io.*;
import java.util.*;

public class Boj_2346_풍선터뜨리기 {

    static class Balloon {
        int index;
        int move;

        public Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Balloon> deque = new ArrayDeque<>();
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1 ");

        for (int i = 1; i < N; i++) {
            deque.add(new Balloon(i + 1, values[i]));
        }

        int move = values[0];

        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    deque.addLast(deque.pollFirst());
                }
                Balloon next = deque.pollFirst();
                move = next.move;
                sb.append(next.index).append(" ");
            } else {
                for (int i = 1; i < -move; i++) {
                    deque.addFirst(deque.pollLast());
                }
                Balloon next = deque.pollLast();
                move = next.move;
                sb.append(next.index).append(" ");
            }
        }

        System.out.println(sb);
    }
}
