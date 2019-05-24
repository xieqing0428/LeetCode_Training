package 初级算法.树;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: No_104_Maximum_Depth_of_Binary_Tree
 * @Description:
 *
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author: XieQing
 * @Date: 2018/11/5 15:15
 * @Version: 1.0
 */
public class No_104_Maximum_Depth_of_Binary_Tree {
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
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> depth = new HashMap<>();
        int temp;
        int max;

        public int maxDepth(TreeNode root) {
            if (root != null) {
                depth.put(root, 1);
                max = 1;
            }
            DFS(root);
            return max;
        }

        public void DFS(TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.left != null || node.right != null) {
                temp = depth.get(node) + 1;
                max = Math.max(temp, max);
            }
            if (node.left != null) {
                stack.push(node.left);
                depth.put(node.left, temp);
            }
            if (node.right != null) {
                stack.push(node.right);
                depth.put(node.right, temp);
            }
            if (stack.empty()) {
                return;
            }
            DFS(stack.pop());
        }
    }

    class SolutionB {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                // 官方：递归
                int left_height = maxDepth(root.left);
                int right_height = maxDepth(root.right);
                return java.lang.Math.max(left_height, right_height) + 1;
            }
        }
    }
}
