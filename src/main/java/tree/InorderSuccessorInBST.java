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
            // if root.val == p.val, go right to find the leftmost of right tree
            // when going right, the current node can't possibly be inorder successor
            if (root.val <= p.val) {
                root = root.right;
            } else {
                // whenever go left, the current node is a candidate for inorder successor
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
