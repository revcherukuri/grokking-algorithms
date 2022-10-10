/*
    EASY
    Returns level order traversal from bottom of tree to root
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> sol = traverse(root);
        System.out.println(sol);
    }

    public static List<List<Integer>> traverse (TreeNode root) {
        List<List<Integer>> traverse = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return traverse;
        }
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelCount = q.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = q.poll();
                currentLevel.add(current.val);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            traverse.add(0, currentLevel);
        }
        return traverse;
    }
}
