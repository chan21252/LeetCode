package t2;/*
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * 结果链表：ls = new ListNode(0)
         * carry = 0;
         * p = l1;
         * q = l2;
         * 暂存结点 curr = ls
         *
         * 当p和q不同时为空
         * x = p!=null ? p.val : 0;
         * y = q!=null ? q.val : 0;
         * s = x + y + carry;
         * 当前位相加结果 num = s % 10;
         * 余数 carry = s / 10;
         * curr.next = new ListNode(num);
         * curr = curr.next
         * p = p.next
         * q = q.next
         *
         * 如果结束后，carry>0
         * curr.next = new ListNode(carry)
         */

        ListNode ls = new ListNode(0);
        ListNode curr = ls;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int s = x + y + carry;
            carry = s / 10;

            curr.next = new ListNode(s % 10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return ls.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l2.next = l22;
        l22.next = l23;

        Solution s = new Solution();
        ListNode l = s.addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
