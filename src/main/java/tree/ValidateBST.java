package tree;

/**
 *
 * No.98 Validate BST. (medium)
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * Date: 02/03/2021
 *
 */
public class ValidateBST {

    public boolean validateBST(TreeNode root) {
        return validateRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * A few things to notice:
     * Use long type in case there are nodes with value of max/min integer value.
     * If duplicates are not allowed, use val <= lo (val >= hi) instead of > or <.
     */
    private boolean validateRecursive(TreeNode node, long lo, long hi) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (val <= lo || val >= hi) {
            return false;
        }
        return validateRecursive(node.left, lo, val) && validateRecursive(node.right, val, hi);
    }

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        TreeNode root = buildValidBST();
        boolean isValidBST = validateBST.validateBST(root);
        System.out.println(isValidBST);

        TreeNode invalidBST = buildInvalidBST();
        boolean isValidBST2 = validateBST.validateBST(invalidBST);
        System.out.println(isValidBST2);
    }

    // todo: build tree string parser
    public static TreeNode buildValidBST() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(50);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(30);
        TreeNode node6 = new TreeNode(80);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return root;
    }

    private static TreeNode buildInvalidBST() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(50);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(80);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return root;
    }
}
