/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, result);
        return result;
    }
    public void dfs(Node root, List<Integer> result) {
        List<Node> childrens = root.children;
        for (Node n : childrens) {
            dfs(n, result);
        }
        result.add(root.val);
    }
}