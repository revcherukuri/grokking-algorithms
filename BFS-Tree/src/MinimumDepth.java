/*
    EASY
    Returns minimum depth of tree from root to nearest leaf node
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepth {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        int depth = findDepth(root);
        System.out.println(depth);
    }

    public static int findDepth (TreeNode root) {
        int minDepth = 0;
        if (root == null) {
            return minDepth;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            minDepth++;
            int levelCount = q.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = q.poll();
                if (current.left == null && current.right == null) {
                    return minDepth;
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return minDepth;
    }
}
