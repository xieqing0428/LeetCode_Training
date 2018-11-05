/**
 * @ClassName: No_237_Delete_Node_in_a_Linked_List
 * @Description:
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *     4 -> 5 -> 1 -> 9
 * 说明:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * @Author: XieQing
 * @Date: 2018/11/1 20:28
 * @Version: 1.0
 */
public class No_237_Delete_Node_in_a_Linked_List {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            // 直接操作节点对象
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
