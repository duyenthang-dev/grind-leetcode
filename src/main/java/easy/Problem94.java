package easy;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Problem94 {
    // NLR
    private List<Integer> result;
    public void rec(TreeNode root, List<Integer> l) {
        if (root != null) {
            rec(root.left, l);
            l.add(root.val);
            rec(root.right, l);
        }

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        rec(root, this.result);
        return result;
    }

    public static void main(String[] args) {

    }
}

