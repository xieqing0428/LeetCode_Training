/**
 * @ClassName: No_206_Reverse_Linked_List
 * @Description:
 * 反转一个单链表。
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @Author: XieQing
 * @Date: 2018/11/2 15:29
 * @Version: 1.0
 */
public class No_206_Reverse_Linked_List {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    class SolutionA {
        ListNode result = new ListNode(0);
        ListNode temp = new ListNode(0);
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode node = new ListNode(0);
            node.next = head;
            // 递归
            helper(node, 0);
            return result.next;
        }
        void helper(ListNode node,int index) {
            if(node.next == null) {
                temp = node;
                result.next = temp;
                return;
            }
            helper(node.next, index + 1);
            if (index == 0) {
                return;
            }
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }
    }
    class SolutionB {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null, nex = null;
            // 迭代
            while (head != null) {
                nex = head.next;
                head.next = pre;
                pre = head;
                head = nex;
            }
            return pre;
        }
    }
}
