package tree;

public class DFS {

    public static void dfs(TreeNode root){
        if (root.left!=null){
            dfs(root.left);
        }
        System.out.println(root.val);
        if (root.right!=null)
            dfs(root.right);
    }
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode four = new TreeNode(4, five, null);
        TreeNode two = new TreeNode(2, four, ten);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode one = new TreeNode(1, two, three);

        dfs(one);
    }
}
