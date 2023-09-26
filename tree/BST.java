package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree {
    public int data;
    public Tree left;
    public Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public static void preorder(Tree root) {
        if (root == null)
            return;

        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(Tree root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static Tree findNode(Tree root, int data) {
        if (root == null)
            return root;
        if (root.data == data)
            return root;
        if (root.data > data)
            return findNode(root.left, data);
        return findNode(root.right, data);
    }

    public static int findCeil(Tree root, int data) {
        int ans = -1;
        while (root != null) {
            if (root.data == data) {
                return data;
            }
            if (root.data > data) {
                ans = root.data;
                root = root.left;
            } else
                root = root.right;

        }
        return ans;
    }

    public static int findFloor(Tree root, int data) {
        int ans = -1;
        while (root != null) {
            if (root.data == data)
                return data;
            if (root.data < data) {
                ans = root.data;
                root = root.right;
            } else
                root = root.left;

        }

        return ans;
    }

    public static Tree insertNode(Tree root, int data) {
        Tree node = new Tree(data);
        if (root == null)
            return node;

        Tree head = root;
        while (true) {
            if (root.data > data) {
                if (root.left != null)
                    root = root.left;
                else {
                    root.left = node;
                    return head;
                }
            } else {
                if (root.right != null)
                    root = root.left;
                else {
                    root.right = node;
                    return head;
                }
            }
        }
    }
    public static Tree deleteNode(Tree root,int data){
        Tree head = root; 
        Tree temp = null;
        while(root != null){
            if(root.data == data){
                temp = root;
                break;
            }
            else if(root.data > data){
                root = root.left;
            }
            else
                root = root.right;
        }
        if(temp == null )return root;

        Tree trav = temp;
        while(trav != null){
            if(trav.right != null){
                trav = trav.right;
            }
            else if(trav.left != null){
                trav = trav.left;
            }
            else{
                break;
            }
        }
        int t = trav.data;
        trav.data = temp.data;
        temp.data = t;
        return null;

    }
    public static void getKthSmallest(Tree root,int k){
        Stack<Tree> st = new Stack<>();
        int cnt = 0;
        Tree node = root;
        while(true){
            if(node != null ){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty())break;
                node = st.pop();
                cnt++;
                if(cnt == k){
                    System.out.print(" "+node.data);
                    break;
                }
                node = node.right;
            }
        }

    }
}

public class BST {
    public static void main(String[] args) {
        Tree root = new Tree(8);
        root.left = new Tree(3);
        root.left.left = new Tree(1);
        root.left.right = new Tree(6);
        root.left.right.left = new Tree(4);
        root.left.right.right = new Tree(7);
        root.right = new Tree(13);
        root.right.right = new Tree(14);
        root.right.left = new Tree(10);

        // Tree.inorder(root);

        // Tree temp = Tree.findNode(root, 1);
        // if(temp == null){
        // System.out.println("not found");
        // }
        // else{
        // System.out.println(" data :"+temp.data);
        // }
        // System.out.println(Tree.findCeil(root, 11));
        // System.out.println(Tree.findFloor(root, 11));

        Tree.inorder(Tree.insertNode(root, 2));

        Tree.getKthSmallest(root, 3);


    }

}
