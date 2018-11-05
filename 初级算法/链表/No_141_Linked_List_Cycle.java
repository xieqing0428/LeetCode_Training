import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: No_141_Linked_List_Cycle
 * @Description:
 * 给定一个链表，判断链表中是否有环。
 * 进阶：
 * 你能否不使用额外空间解决此题？
 * @Author: XieQing
 * @Date: 2018/11/4 23:07
 * @Version: 1.0
 */
public class No_141_Linked_List_Cycle {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class SolutionA {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            if (head == null || head.next == null) {
                return false;
            }
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
    public class SolutionB {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> nodesSeen = new HashSet<>();
            while (head != null) {
                if (nodesSeen.contains(head)) {
                    return true;
                } else {
                    nodesSeen.add(head);
                }
                head = head.next;
            }
            return false;
        }
    }
}
