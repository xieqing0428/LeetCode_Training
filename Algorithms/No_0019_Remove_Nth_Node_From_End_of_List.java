package 初级算法.链表;

/**
 * @ClassName: No_0019_Remove_Nth_Node_From_End_of_List
 * @Description:
 *
 * 0019. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @Author: XieQing
 * @Date: 2018/11/2 11:27
 * @Version: 1.0
 */
public class No_0019_Remove_Nth_Node_From_End_of_List {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    class SolutionA {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = new ListNode(0);
            node.next = head;
            ListNode temp = head;
            int len = 0;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            len -= n;
            temp = node;
            while (len > 0) {
                len--;
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return node.next;
        }
    }
    class SolutionB {
        int length = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = new ListNode(0);
            node.next = head;
            helper(node,0,n);
            return node.next;
        }

        void helper(ListNode node,int index,int n){
            if(node.next == null) {
                length = index;
                return;
            }
            helper(node.next, index+1,n);
            if(index == length - n)
                node.next = node.next.next;
        }
    }
}
