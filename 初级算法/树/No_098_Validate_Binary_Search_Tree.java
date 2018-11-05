import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: No_098_Validate_Binary_Search_Tree
 * @Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @Author: XieQing
 * @Date: 2018/11/5 19:00
 * @Version: 1.0
 */
public class No_098_Validate_Binary_Search_Tree {
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
        Map<TreeNode, Integer> max = new HashMap<>();
        Map<TreeNode, Integer> min = new HashMap<>();
        int markMax = -1;
        int markMin = -1;
        boolean mark = true;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (mark) {
                stack.push(root);
                max.put(root, Integer.MAX_VALUE);
                min.put(root, Integer.MIN_VALUE);
                // 边界值排除
                if (root.val == Integer.MIN_VALUE) {
                    markMin++;
                }
                if (root.val == Integer.MAX_VALUE) {
                    markMax++;
                }
                mark = false;
                stack.pop();
            }
            if (root.left != null) {
                if (root.left.val == Integer.MIN_VALUE) {
                    markMin++;
                }
                stack.push(root.left);
                max.put(root.left, root.val);
                min.put(root.left, min.get(root));
                if (markMin == 0) {
                    if (root.left.val >= root.val || root.left.val < min.get(root.left)) {
                        markMin++;
                        return false;
                    }
                } else {
                    if (root.left.val >= root.val || root.left.val <= min.get(root.left)) {
                        return false;
                    }
                }
            }
            if (root.right != null) {
                if (root.right.val == Integer.MAX_VALUE) {
                    markMax++;
                }
                stack.push(root.right);
                max.put(root.right, max.get(root));
                min.put(root.right, root.val);
                if (markMax == 0) {
                    if (root.right.val <= root.val || root.right.val > max.get(root.right)) {
                        markMax++;
                        return false;
                    }
                } else {
                    if (root.right.val <= root.val || root.right.val >= max.get(root.right)) {
                        return false;
                    }
                }
            }
            if (stack.empty()) {
                return true;
            }
            return isValidBST(stack.pop());
        }
    }

    class SolutionB {
        public boolean isValidBST(TreeNode root) {
            if (root == null) { return true; }
            TreeNode left = root.left;
            TreeNode right = root.right;

            if (left != null && left.right != null) {
                TreeNode leftRight = left.right;
                while (leftRight.right != null) {
                    leftRight = leftRight.right;
                }
                if (leftRight.val >= root.val) { return false; }
            }

            if (right != null && right.left != null) {
                TreeNode rightLeft = right.left;
                while (rightLeft.left != null) {
                    rightLeft = rightLeft.left;
                }
                if (rightLeft.val <= root.val) { return false; }
            }
            if (left != null && left.val >= root.val) { return false; }
            if (right != null && right.val <= root.val) { return false; }
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }
}
