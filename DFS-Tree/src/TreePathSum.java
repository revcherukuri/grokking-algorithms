/*
    EASY
    Checks if path from root to leaf exists that adds to given sum
 */

import java.util.Stack;

public class TreePathSum {
    public static void main (String [] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode (7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        boolean pathExists = searchForPath (root, 23);
        boolean pathExists2 = searchForPath(root, 10);
        System.out.println(pathExists);
        System.out.println(pathExists2);
    }

    public static boolean searchForPath (TreeNode root, int sum) {              // Iterative Depth First approach using stack
        if (root == null) {
            return false;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;                                // keeps track of current node to process
        while (current != null || s.size() > 0) {               // traverse tree as long as: 1. current is not null (previous node was a leaf and left/right was called) OR 2. stack size is greater than 0 (touched all nodes)
            if (sum == 0) {                                     // since we decrement/increment given sum whenever we push/pop a node, when the sum is zero that means we found a path that adds to it
                return true;
            }
            if (current != null) {                              // if we are on an existing node
                s.push(current);                                // put it on stack
                sum -= current.val;                             // decrement its value from the given sum
                current = current.left;                         // set current node as its left child
            }
            else {                                              // we found a node and went to its nonexistent left or right child, which is what current is pointing to at this moment
                current = s.pop();                              // pop most recent node on stack, which is the immediate parent.
                if (current.right == null) {                    // add the value of this node back to the sum, because we know this is not a valid path.
                    sum += current.val;                         // we only add if it doesn't have right children, because we dont want to lose this node's value if there are more children nodes on the right side. There could be a possible valid path there, with this parent's value.
                }
                current = current.right;                        // set current node as most recently popped node's right child. We basically went outside the tree by trying to go left of a node, went back up to the node, and now we are going to the right
            }
        }
        return false;                                           // no path exists
    }
}
