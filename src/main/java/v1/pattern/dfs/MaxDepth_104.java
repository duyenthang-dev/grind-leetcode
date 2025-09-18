package v1.pattern.dfs;

public class MaxDepth_104 {
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        // thăm child -> tăng thêm 1;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root);
    }
    
}
