/**
 * @ClassName: No_108_Convert_Sorted_Array_to_Binary_Search_Tree
 * @Description:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @Author: XieQing
 * @Date: 2018/11/5 23:07
 * @Version: 1.0
 */
public class No_108_Convert_Sorted_Array_to_Binary_Search_Tree {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            // 二分
            return convert(nums, 0, nums.length - 1);
        }
        public TreeNode convert(int[] nums, int l, int r) {
            if (l <= r) {
                int mid = (r + l) / 2;
                TreeNode node = new TreeNode(nums[mid]);
                node.left = convert(nums, l, mid - 1);
                node.right = convert(nums, mid + 1, r);
                return node;
            } else {
                return null;
            }
        }
    }
}
