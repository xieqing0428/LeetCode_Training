/**
 * @ClassName: No_021_Merge_Two_Sorted_Lists
 * @Description:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author: XieQing
 * @Date: 2018/11/2 17:22
 * @Version: 1.0
 */
public class No_021_Merge_Two_Sorted_Lists {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class SolutionA {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode t1, t2;
            ListNode temp = new ListNode(0);
            ListNode result = new ListNode(0);
            result.next = temp;
            while (l1 != null && l2 != null) {
                t1 = l1.next;
                t2 = l2.next;
                l1.next = null;
                l2.next = null;
                if (l1.val <= l2.val) {
                    temp.next = l1;
                    temp = temp.next;
                    l1 = t1;
                    l2.next = t2;
                } else {
                    temp.next = l2;
                    temp = temp.next;
                    l2 = t2;
                    l1.next = t1;
                }
            }
            if (l1 != null) {
                temp.next = l1;
            }
            if (l2 != null) {
                temp.next = l2;
            }
            return result.next.next;
        }
    }
    class SolutionB {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode flag = new ListNode(0);
            ListNode firstflag = flag;
            while (l1 != null && l2 != null) {
                if(l1.val < l2.val){
                    flag.next = l1;
                    l1 = l1.next;
                }else {
                    flag.next = l2;
                    l2 = l2.next;
                }
                flag = flag.next;
            }
            flag.next = l1 != null ? l1 : l2;
            return firstflag.next;
        }
    }
}
