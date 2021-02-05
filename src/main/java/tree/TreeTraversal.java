package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderRecursive(res, root);
        return res;
    }

    private void inorderRecursive(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        inorderRecursive(res, node.left);
        res.add(node.val);
        inorderRecursive(res, node.right);
    }

    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode bst = ValidateBST.buildValidBST();
        List<Integer> inorder = treeTraversal.inorder(bst);
        inorder.forEach(System.out::println);  // BST inorder should be sorted array
    }

}
