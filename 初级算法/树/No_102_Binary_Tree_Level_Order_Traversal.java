import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: No_102_Binary_Tree_Level_Order_Traversal
 * @Description: 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Author: XieQing
 * @Date: 2018/11/5 22:26
 * @Version: 1.0
 */
public class No_102_Binary_Tree_Level_Order_Traversal {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    class SolutionA {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(level);
            }
            return result;
        }
    }

    class SolutionB {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> l = new ArrayList<>();
            addLevel(l, 0, root);
            return l;
        }

        public void addLevel(List<List<Integer>> list, int level, TreeNode node) {
            if (node == null) { return; }
            if (list.size() - 1 < level) { list.add(new ArrayList<>()); }
            list.get(level).add(node.val);

            addLevel(list, level + 1, node.left);
            addLevel(list, level + 1, node.right);
        }
    }
}
