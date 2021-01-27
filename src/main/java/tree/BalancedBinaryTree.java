package tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * No.110 Balanced Binary Tree.
 *
 * Date: 01/26/2021
 */
public class BalancedBinaryTree {

    @NoArgsConstructor
    @AllArgsConstructor
    class TreeInfo {
        int height;
        boolean isBalanced;
    }

    /**
     * time: O(n)
     * space: O(logn) if balanced
     */
    public boolean isBalanced(TreeNode root) {
        return recursive(root).isBalanced;
    }

    private TreeInfo recursive(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo left = recursive(root.left);
        TreeInfo right = recursive(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diff = Math.abs(left.height - right.height);
        boolean isBalanced = left.isBalanced && right.isBalanced && diff <= 1;
        return new TreeInfo(height, isBalanced);
    }


    /**
     * ----------------------------------------------------------------------
     * Use error code, instead of wrapper class.
     * ----------------------------------------------------------------------
     */
    private static final int ERROR_CODE = Integer.MIN_VALUE;

    public boolean isBalancedII(TreeNode root) {
        return height(root) != ERROR_CODE;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // shortcut return ERROR_CODE
        if (leftHeight == ERROR_CODE || rightHeight == ERROR_CODE) {
            return ERROR_CODE;
        }

        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return ERROR_CODE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
