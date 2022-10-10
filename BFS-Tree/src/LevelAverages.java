/*
    EASY
    Returns list of value averages for each level
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverages {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> averages = findAverages(root);
        System.out.println(averages);
    }

    public static List<Double> findAverages (TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) {
            return averages;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelCount = q.size();
            int levelSum = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = q.poll();
                levelSum += current.val;
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            averages.add(1.0 * levelSum / levelCount);
        }
        return averages;
    }
}
