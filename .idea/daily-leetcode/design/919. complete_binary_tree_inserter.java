/**
 * https://leetcode.com/problems/complete-binary-tree-inserter/description/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    TreeNode rootNode;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        queue = new ArrayDeque<>();

        rootNode = root;
        queue.add(root);
    }

    public int insert(int val) {
        TreeNode curr = queue.peek();

        if (curr.left == null) {
            curr.left = new TreeNode(val);
            queue.add(curr.left);
            return curr.val;
        } else {
            queue.add(curr.left);
        }

        if (curr.right == null) {
            curr.right = new TreeNode(val);
            queue.add(curr.right);
            return curr.val;
        } else {
            queue.add(curr.right);
        }

        queue.poll();
        return insert(val);
    }

    public TreeNode get_root() {
        return rootNode;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */