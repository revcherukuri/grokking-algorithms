/*
    MEDIUM
    Returns sum of all paths from root to each leaf
 */

public class SumOfPathNumbers {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        int sum = findSum(root);
        System.out.println(sum);
    }

    public static int findSum (TreeNode root) {
        return findSumRecursive (root, 0);
    }

    public static int findSumRecursive (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return findSumRecursive(root.left, sum) + findSumRecursive(root.right, sum);        // if root.left or root.right is null, it will return 0 and the root will go back to the previous root, it will not update to the null root.
    }
}
