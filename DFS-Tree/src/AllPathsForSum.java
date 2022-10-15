/*
    MEDIUM
    Returns number of paths from root the leaf that add to given sum
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsForSum {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode (7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        int pathCount = findPaths (root, 12);
        System.out.println(pathCount);
    }

    public static int findPaths (TreeNode root, int sum) {
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        findPathsRecursive(root, sum, allPaths, currentPath);
        return allPaths.size();
    }

    public static void findPathsRecursive (TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> currentPath) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            allPaths.add(currentPath);
        }
        else {
            findPathsRecursive(root.left, sum - root.val, allPaths, currentPath);
            findPathsRecursive(root.right, sum - root.val, allPaths, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
