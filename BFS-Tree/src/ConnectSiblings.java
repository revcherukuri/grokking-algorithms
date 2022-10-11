/*
    MEDIUM
    Assigns "next" pointer of node to the node on its right in the same level. If it is the last node in the level, then "next" points to null. Prints tree using "next" pointer
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectSiblings {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        connect(root);
        System.out.println("Done");

        printTree(root);
    }

    public static void connect (TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelCount = q.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = q.poll();
                if (i ==  levelCount-1) {
                    current.next = null;
                }
                else {
                    current.next = q.peek();
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> l = new ArrayList<>();
            int levelCount = q.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = q.poll();
                l.add(current);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            System.out.print(l.get(0).val + " -> ");
            for (int i = 0; i < l.size(); i++) {
                if  (l.get(i).next != null)
                    System.out.print(l.get(i).next.val + " -> ");
                else
                    System.out.print("NULL");
            }
            System.out.println();
        }
    }
}
