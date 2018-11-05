/**
 * @ClassName: No_234_Palindrome_Linked_List
 * @Description:
 * 请判断一个链表是否为回文链表。
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @Author: XieQing
 * @Date: 2018/11/4 22:48
 * @Version: 1.0
 */
public class No_234_Palindrome_Linked_List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    class SolutionA {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode temp = head;
            ListNode _h = new ListNode(0);
            ListNode index = new ListNode(-1);
            index.next = _h;
            ListNode prefix = null, suffix = null;
            // reverse
            while (temp != null) {
                _h.next = new ListNode(temp.val);
                _h = _h.next;
                suffix = temp.next;
                temp.next = prefix;
                prefix = temp;
                temp = suffix;
            }
            _h = index.next.next;
            // compare
            while (prefix != null && _h != null) {
                if (prefix.val == _h.val) {
                    prefix = prefix.next;
                    _h = _h.next;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
    class SolutionB {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            if (fast == null || fast.next == null)//0个节点或是1个节点
            { return true; }


            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            //对链表后半段进行反转
            ListNode midNode = slow;
            ListNode firNode = slow.next;//后半段链表的第一个节点
            ListNode cur = firNode.next;//插入节点从第一个节点后面一个开始
            firNode.next = null;//第一个节点最后会变最后一个节点
            while (cur != null) {
                ListNode nextNode = cur.next;//保存下次遍历的节点
                cur.next = midNode.next;
                midNode.next = cur;
                cur = nextNode;
            }

            //反转之后对前后半段进行比较
            slow = head;
            fast = midNode.next;
            while (fast != null) {
                if (fast.val != slow.val) { return false; }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
    }
}
