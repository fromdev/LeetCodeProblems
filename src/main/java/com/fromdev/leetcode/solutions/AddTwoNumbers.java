package com.fromdev.leetcode.solutions;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = newListNode(Integer.MAX_VALUE);
        ListNode l2 = newListNode(119876);
        ListNode sum = addTwoNumbers.addTwoNumbers(l1,l2,0);
        print(l1);
        System.out.print(" + ");
        print(l2);
        System.out.print(" = ");
        print(sum);
    }

    public static ListNode newListNode(int number) {
        int mod = number % 10;
        int div = number / 10;
        ListNode l = new ListNode(mod);
        if(div > 0) {
            l.next = newListNode(div);
        }
        return l;
    }
    public static void print(ListNode l) {
        if (l.next != null) {
            print(l.next);
        }
        System.out.print(l.val);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sumWithCarryOver = l1.val + l2.val;
        ListNode sum = new ListNode(sumWithCarryOver % 10);
        ListNode caryOverNode = new ListNode(sumWithCarryOver / 10);
        if(l1.next != null && l2.next != null) {
            ListNode addedCaryOverToFirst = new ListNode(l1.next.val + caryOverNode.val);
            addedCaryOverToFirst.next = l1.next.next;
            sum.next = addTwoNumbers(addedCaryOverToFirst , l2.next);
        }

        if(l1.next == null && l2.next != null) {
            sum.next = addTwoNumbers(caryOverNode,l2.next);
        }
        if(l1.next != null && l2.next == null) {
            sum.next = addTwoNumbers(caryOverNode,l1.next);
        }
        if(l1.next == null && l2.next == null && caryOverNode.val > 0) {
            sum.next = caryOverNode;
        }
        return sum;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        int val1 = (l1 == null) ? 0 : l1.val;
        int val2 = (l2 == null) ? 0 : l2.val;
        int sum = val1 + val2 + carry;
        carry = sum / 10;
        ListNode sumNode = new ListNode(sum % 10);
        l1 = (l1 == null) ? null : l1.next;
        l2 = (l2 == null) ? null : l2.next;
        if(l1 != null || l2 != null || carry > 0) {
            sumNode.next = addTwoNumbers(l1,l2,carry);
        }
        return sumNode;
    }

    //from forum answer
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        return head.next;
    }
}

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


