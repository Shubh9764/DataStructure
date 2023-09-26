package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public static boolean check(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.data != root2.data) {
            return false;
        }
        boolean left = check(root1.left, root2.left);
        boolean right = check(root1.right, root2.right);
        return left && right;
    }

    public static boolean printPath(Node root, int data, ArrayList<Integer> arr) {
        if (root == null) {
            return false;
        }
        arr.add(root.data);
        if (root.data == data)
            return true;
        if (printPath(root.left, data, arr) || printPath(root.right, data, arr))
            return true;
        arr.remove(arr.size() - 1);
        return false;
    }

    public static int getLCA(Node root, int a, int b) {
        if (root == null)
            return -1;
        if (root.data == a || root.data == b)
            return root.data;
        int left = getLCA(root.left, a, b);
        int right = getLCA(root.right, a, b);
        if (left != -1 && right != -1) {
            return root.data;
        } else if (left != -1) {
            return left;
        }
        return right;

    }

    public static Node mapToparent(Node root, Map<Node, Node> map, int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node res = null;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == start)
                res = curr;
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }

        }
        return res;
    }

    public static int timeTakenToBurnTree(Node root, int start) {
        Map<Node, Node> map = new HashMap<>();
        Node target = mapToparent(root, map, start);

        int ans = findMaxTimeTaken(target, map, start);
        return ans;
    }

    private static int findMaxTimeTaken(Node root, Map<Node, Node> map, int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Map<Node, Boolean> vis = new HashMap<>();
        vis.put(root, true);
        int ans = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean flag = false;
            for (int i = 0; i < sz; i++) {
                Node curr = q.poll();

                if (map.get(curr) != null && vis.get(map.get(curr)) == null) {
                    flag = true;
                    q.add(map.get(curr));

                }
                if (curr.left != null && vis.get(curr.left) == null) {
                    flag = true;
                    q.add(curr.left);
                    vis.put(curr.left, true);
                }

                if (curr.right != null && vis.get(curr.right) == null) {
                    flag = true;
                    q.add(curr.right);
                    vis.put(curr.right, true);
                }
            }
            if (flag)
                ans++;
        }

        return ans;
    }
    public static int getLeftHeight(Node root){
        int ht =0;
        while(root != null){
            ht++;
            root = root.left;
        }
        return ht;
    }

     public static int getRightHeight(Node root){
        int ht =0;
        while(root != null){
            ht++;
            root = root.right;
        }
        return ht;
    }

    public static int getNumberOfNode(Node root){
        if(root == null)return 0;
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);

        if(leftHeight == rightHeight)
        return (int)Math.pow(2, rightHeight) - 1;

        return getNumberOfNode(root.left) + getNumberOfNode(root.right) + 1;

    }

    public static Node createTreeFromPreAndIn(int[]pre,int[]in){

    }
    static class Pair {
        int num;
        Node node;

        public Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static void printWidth(Node root) {

        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int curr_id = q.peek().num - min;
                Node currNode = q.poll().node;
                if (i == 0)
                    first = curr_id;
                if (i == size - 1)
                    last = curr_id;
                if (currNode.left != null) {
                    q.offer(new Pair(currNode.left, curr_id * 2 + 1));
                }
                if (currNode.right != null) {
                    q.offer(new Pair(currNode.right, curr_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        System.out.println("max width : " + ans);
    }
}

/*
 * 
 * 1
 * 2 3
 * 4 5 6 7
 * 8 9
 * 
 */

public class Tree {
    public static void main(String[] args) {
        System.out.println("hi");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // Node root1 = new Node(1);
        // root1.left = new Node(2);
        // root1.right = new Node(3);
        // root1.left.left = new Node(4);
        // root1.left.right = new Node(5);
        // root1.left.right.left = new Node(8);
        // root1.left.right.right = new Node(9);
        // root1.right.left = new Node(6);
        // root1.right.right = new Node(7);
        // ArrayList<Integer> arr = new ArrayList<>();
        // System.out.println(Node.printPath(root, 9, arr));
        // System.out.println(arr);
        // int a = 4, b = 9;
        // System.out.println(" LCA of " + a + " and " + b + " = " + Node.getLCA(root, a, b));
        // Node.printWidth(root);
        // System.out.println();
        // System.out.println(Node.timeTakenToBurnTree(root, 2));
      

     
    }

}
