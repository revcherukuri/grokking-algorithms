/*
    EASY
    Returns successor node of given node in tree, i.e. the node which appears next in level order traversal
 */

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(9);
        TreeNode successor = findNode (root, 9);
        System.out.println(successor.val);
    }

    public static TreeNode findNode (TreeNode root, int val) {
        TreeNode successor = null;
        if (root == null) {
            return successor;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
            if (current.val == val) {
                break;
            }
        }
        return q.poll();
    }
}
