/*
    MEDIUM
    Returns whether or not a path from root to leaf exists following a given sequence
 */

public class PathWithSequence {
    public static void main (String [] args) {
        TreeNode root = new TreeNode (1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        int [] seq1 = new int [] {1,0,7};
        int [] seq2 = new int [] {1,1,6};
        boolean pathExists = findIfPathExists(root, seq1);
        boolean pathExists2 = findIfPathExists (root, seq2);
        System.out.println(pathExists);
        System.out.println(pathExists2);
    }

    public static boolean findIfPathExists (TreeNode root, int [] sequence) {
        return findIfPathExistsRecursive (root, sequence);
    }

    public static boolean findIfPathExistsRecursive (TreeNode root, int [] sequence) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sequence[sequence.length - 1]) {
            return true;
        }
        return findIfPathExistsRecursive(root.left, sequence) || findIfPathExistsRecursive(root.right, sequence);
    }
}
