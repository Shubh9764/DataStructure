package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Tree1
 */
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void levelorder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    public static void Ipreorder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    public static void Iinorder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    return;
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }

        }
    }

    public static void Ipostorder1(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node curr = st1.pop();
            if (curr.left != null) {
                st1.push(curr.left);
            }
            if (curr.right != null) {
                st1.push(curr.right);
            }
            st2.push(curr);
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }

    }

    public static void Ipostorder2(Node root) {
        Stack<Node> st1 = new Stack<>();
        while (root != null || !st1.isEmpty()) {
            if (root != null) {
                st1.push(root);
                root = root.left;
            } else {
                Node temp = st1.peek().right;
                if (temp == null) {
                    temp = st1.pop();
                    System.out.print(temp.data + " ");
                    while (!st1.isEmpty() && temp == st1.peek().right) {
                        temp = st1.pop();
                        System.out.print(temp.data + " ");
                    }
                } else
                    root = temp;
            }
        }

    }

    public static void allTraversals(Node root) {
        Stack<Pair> st = new Stack<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair curr = st.peek();

            if (curr.cnt == 1) {
                if (curr.node.left != null)
                    st.push(new Pair(curr.node.left, 1));
                preorder.add(curr.node.data);
            } else if (curr.cnt == 2) {
                if (curr.node.right != null) {
                    st.push(new Pair(curr.node.right, 1));
                }
                inorder.add(curr.node.data);
            } else if (curr.cnt == 3) {
                postorder.add(curr.node.data);
                st.pop();
            }
            curr.cnt++;
        }
        System.out.println(preorder.toString());
        System.out.println(inorder.toString());
        System.out.println(postorder.toString());

    }

    public static int getHeight(Node root) {
        if (root == null)
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static int diameter = -1;

    public static int getDiameter(Node root) {
        if (root == null)
            return 0;
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);
        System.out.println("left : " + left + ",  right : " + right);
        diameter = Math.max(diameter, (left + right));
        return Math.max(left, right) + 1;
    }

    public static int maxSum = -1;

    public static int getMaxPathSum(Node root) {
        if (root == null)
            return 0;
        int left = getMaxPathSum(root.left);
        int right = getMaxPathSum(root.right);
        maxSum = Math.max(maxSum, (left + right + root.data));
        return root.data + Math.max(left, right);
    }

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        boolean left = isIdentical(root1.left, root2.left);
        boolean right = isIdentical(root1.right, root2.right);
        return left && right && root1.data == root2.data;

    }

    public static void zigzagTrav(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean dir = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] ans = new int[size];
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                int index = (dir) ? i : size - 1 - i;
                ans[index] = curr.data;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            dir = !dir;
            System.out.println(Arrays.toString(ans));
        }
    }
    public static void leftBoudary(Node root){
        Node left = root.left;
        while(left != null){
            if(left.left != null || left.right != null)
             System.out.print(" "+left.data);
             if(left.left != null)
             left = left.left;
             else
             left = left.right;
        }
    }
     public static void rightBoudary(Node root){
        Node right = root.right;
        while(right != null){
            if(right.left != null || right.right != null)
             System.out.print(" "+right.data);
             if(right.right != null)
             right = right.right;
             else
             right = right.left;
        }
    }
    public static void leafBoudary(Node leaf){
        //  System.out.println(" "+leaf.left.data + " "+ leaf.right.data);
       if(leaf.right == null && leaf.left == null){
         System.out.print(" "+leaf.data);
         return;
        }
        if(leaf.left != null )leafBoudary(leaf.left);
        if(leaf.right != null ) leafBoudary(leaf.right); 
    }

    public static void boundaryTrav(Node root){
        System.out.print(" "+root.data);
        leftBoudary(root);
        System.out.println();
        leafBoudary(root);
        System.out.println();
        rightBoudary(root);
    }
    public static void verticalTrav(Node root){
        class Tuple{
            Node node;
            int row;
            int col;
            public Tuple(Node node,int row,int col){
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        while(!q.isEmpty()){
            Tuple t = q.poll();
            Node curr = t.node;
            int x = t.row;
            int y = t.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(curr.data);
            if(curr.left != null){
                q.add(new Tuple(curr.left, x - 1, y + 1));
            }
             if(curr.right != null){
                q.add(new Tuple(curr.right, x + 1, y + 1));
            }
        } 
                    System.out.println(map);

    }

    public static void topView(Node root){
        class Pair{
            Node node;
            int line;
            public Pair(Node node,int line){
                this.node = node;
                this.line = line;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair t = q.poll();
            Node curr = t.node;
            int x = t.line;
            if(!map.containsKey(x)){
                map.put(x,curr.data);
            }
            if(curr.left != null){
                q.add(new Pair(curr.left,x - 1));
            }
            if(curr.right != null){
                q.add(new Pair(curr.right,x + 1));
            }
        } 
                    System.out.println(map);

    }
    public static void bottomView(Node root){
        class Pair{
            Node node;
            int line;
            public Pair(Node node,int line){
                this.node = node;
                this.line = line;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair t = q.poll();
            Node curr = t.node;
            int x = t.line;
                map.put(x,curr.data);
            if(curr.left != null){
                q.add(new Pair(curr.left,x - 1));
            }
            if(curr.right != null){
                q.add(new Pair(curr.right,x + 1));
            }
        } 
                    System.out.println(map);

    }
    public static void leftView(Node root){
         class Pair{
            Node node;
            int line;
            public Pair(Node node,int line){
                this.node = node;
                this.line = line;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int x = p.line;
            if(x == map.size()){
                 System.out.print(" "+curr.data);
                 map.put(x, curr.data);
            }
            // if(!map.containsKey(x)){
            //     map.put(x,curr.data);
            // } 
            if(curr.left != null){
                q.add(new Pair(curr.left, x + 1));
            }
             if(curr.right != null){
                q.add(new Pair(curr.right,x + 1));
            }  
            

        }
        // System.out.println(map);
    }

     public static Node createTreeFromPreAndIn(int[]pre,int preStart, int preEnd,int[]in,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd)return null;
        Node curr = new Node(pre[preStart]);
        int inRoot = map.get(curr.data);
        int numsLeft = inRoot - inStart;
        curr.left = createTreeFromPreAndIn(pre,preStart + 1,preEnd,in,inStart,inRoot - 1,map);
        curr.right = createTreeFromPreAndIn(pre,preStart + numsLeft + 1,preEnd,in,inRoot + 1,inEnd ,map);

        return curr;
    }
    public static Node createTreeFromPostAndIn(int[]post,int postStart,int postEnd,int[] in , int inStart ,int inEnd,HashMap<Integer,Integer>map){
        if(postStart > postEnd || inStart > inEnd)return null;
        Node curr = new Node(post[postEnd]);
        int inRoot = map.get(curr.data);
        int numsLeft = inRoot - inStart;
        curr.left = createTreeFromPostAndIn(post,postStart ,postStart + numsLeft - 1,in,inStart,inRoot - 1,map);
        curr.right = createTreeFromPostAndIn(post,postStart + numsLeft,postEnd - 1,in,inRoot + 1,inEnd,map);
        return curr;
        
    }
    /*
     * 1
     * 2 3
     * 4 5 6 7
     */
}

class Pair {
    Node node;
    int cnt;

    public Pair(Node node, int cnt) {
        this.node = node;
        this.cnt = cnt;
    }
}

public class Tree1 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node root2 = new Node(1);
        // root2.left = new Node(2);
        // root2.right = new Node(3);
        // root2.left.left = new Node(4);
        // root2.left.right = new Node(5);
        // root2.right.left = new Node(6);
        // root2.right.right = new Node(7);

        // Node.preorder(root);
        // System.out.println();
        // // Node.Ipreorder(root);
        // Node.postorder(root);
        // System.out.println();
        // // Node.Ipostorder1(root);
        // Node.Iinorder(root);
        // System.out.println();
        // Node.Ipostorder2(root);
        // // Node.inorder(root);
        // System.out.println();
        // Node.allTraversals(root);
        // // // Node.levelorder(root);

        // System.err.println("Height: "+Node.getHeight(root));

        // System.err.println("Height: "+Node.getDiameter(root));
        // System.err.println("Diameter: "+Node.diameter);
        // System.out.println(Node.getMaxPathSum(root));
        // System.err.println("maxSum: "+Node.maxSum);

        // System.out.println(Node.isIdentical(root, root2));
        // Node.zigzagTrav(root);
        // Node.boundaryTrav(root);
        // System.out.println();
        // Node.verticalTrav(root);
        // System.out.println();
        // Node.topView(root);
        // System.out.println();
        // Node.bottomView(root);                
        // System.out.println();
        // Node.leftView(root);
        // Node.postorder(root);

        int [] pre =new int[]{10,20,40,50,30,60};
        int [] in = new int[]{40,20,50,10,60,30};
        int [] post = new int[]{40,50,20,60,30,10};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < in.length ;i++){
            map.put(in[i], i);
        }


        // Node newNode = Node.createTreeFromPreAndIn(pre,0,pre.length - 1,in,0,in.length - 1,map);
        Node newNode = Node.createTreeFromPostAndIn(post, 0, post.length - 1, in, 0, in.length - 1, map);
        Node.inorder(newNode);
        System.out.println();
        Node.preorder(newNode);
        System.out.println();
        Node.postorder(newNode);


    }
}