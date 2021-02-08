package tree;

/**
 * No.285. Inorder Successor in BST. (medium)
 *
 * Date: 02/04/2021
 *
 */
public class InorderSuccessorInBST {

    /**
     * time: O(H) - H: tree height
     * space: O(1)
     */
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode res = null;
        while (root != null) {
            // if smaller or equal, current node is definitely not a successor
            if (root.val <= p.val) {
                root = root.right;
            } else {
                // if bigger, current node is one of the successors, but not necessarily the closest
                // mark it as the candidate
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
