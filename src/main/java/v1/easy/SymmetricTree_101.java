package v1.easy;


public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return check(left.left, left.right ) && check(right.right, right.left);
    }

    public static void main(String[] args) {
//        int[] root = {1,2,2,3,4,4,3};
//        System.out.println(new Problem101().isSymmetric(root));
    }
}
