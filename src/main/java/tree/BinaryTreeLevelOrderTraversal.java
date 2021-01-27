package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.102 Binary Tree Level Order Traversal. (medium)
 *
 * Date: 01/26/2021
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Find level order using BFS.
     *
     * time: O(n)
     * space: O(l), where l is the length of the longest level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> curLevel = new ArrayList<>();
            res.add(curLevel);

            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null)  queue.add(node.right);
            }

        }
        return res;
    }

    /**
     * Find level order recursively.
     *
     * time: O(n)
     * space: O(logn) if balanced, O(n) if not
     */
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        recursive(res, 0, root);
        return res;
    }

    private void recursive(List<List<Integer>> res, int height, TreeNode node) {
        if (node == null) {
            return;
        }

        // do not use res.get(height) == null
        if (res.size() == height) {
            res.add(new ArrayList<>());
        }
        List<Integer> curDepth = res.get(height);
        curDepth.add(node.val);

        recursive(res, height + 1, node.left);
        recursive(res, height + 1, node.right);
    }
}
