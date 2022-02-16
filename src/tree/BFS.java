package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static void bfs(TreeNode root, Queue<TreeNode> queue){
        System.out.println(root.val);
        if (root.left!=null){
            queue.add(root.left);
        }
        if (root.right!=null){
            queue.add(root.right);
        }

        if(!queue.isEmpty())
            bfs(queue.remove(), queue);
    }
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode four = new TreeNode(4, five, null);
        TreeNode two = new TreeNode(2, four, ten);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode one = new TreeNode(1, two, three);

        bfs(one, new LinkedList<>());
    }
}
