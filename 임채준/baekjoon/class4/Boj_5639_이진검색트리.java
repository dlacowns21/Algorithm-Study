package class4;

import java.io.*;
import java.util.*;

public class Boj_5639_이진검색트리 {

	static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int newValue) {
            if (newValue < this.value) {
                if (this.left == null) {
                    this.left = new Node(newValue);
                } else {
                    this.left.insert(newValue);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(newValue);
                } else {
                    this.right.insert(newValue);
                }
            }
        }

        public void postOrderPrint() {
            if (this.left != null) this.left.postOrderPrint();
            if (this.right != null) this.right.postOrderPrint();
            System.out.println(this.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Node root = null;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            if (root == null) {
                root = new Node(value);
            } else {
                root.insert(value);
            }
        }

        if (root != null) {
            root.postOrderPrint();
        }
    }

}
