import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: No_101_Symmetric_Tree
 * @Description: 给定一个二叉树，检查它是否是镜像对称的。
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * @Author: XieQing
 * @Date: 2018/11/5 20:07
 * @Version: 1.0
 */
public class No_101_Symmetric_Tree {
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            Stack<TreeNode> left = new Stack<>();
            Stack<TreeNode> right = new Stack<>();
            left.push(root);
            right.push(root);
            TreeNode tempLeft, tempRight;
            while (!left.empty() && !right.empty()) {
                tempLeft = left.pop();
                tempRight = right.pop();
                if (tempLeft == null && tempRight == null) {
                    continue;
                }
                if (tempLeft == null || tempRight == null) {
                    return false;
                }
                if (tempLeft.val != tempRight.val) {
                    return false;
                }
                left.push(tempLeft.left);
                left.push(tempLeft.right);
                right.push(tempRight.right);
                right.push(tempRight.left);

            }
            return true;
        }
    }

    class SolutionB {
        // 官方：递归
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        public boolean isMirror(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) { return true; }
            if (t1 == null || t2 == null) { return false; }
            return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
        }
    }

    class SolutionC {
        // 官方：迭代
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t1 = q.poll();
                TreeNode t2 = q.poll();
                if (t1 == null && t2 == null) { continue; }
                if (t1 == null || t2 == null) { return false; }
                if (t1.val != t2.val) { return false; }
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
            return true;
        }
    }
}
