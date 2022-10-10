/*
    MEDIUM
    Returns level order traversal of Tree, the nodes are populated in alternating order between left to right and right to left by level.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> sol = traverse(root);
        System.out.println(sol);
    }

    public static List<List<Integer>> traverse (TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelCount = q.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = q.poll();
                if (leftToRight) {
                    currentLevel.add(current.val);
                }
                else {
                    currentLevel.add(0, current.val);
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            leftToRight = !leftToRight;
            traversal.add(currentLevel);
        }
        return traversal;
    }
}
