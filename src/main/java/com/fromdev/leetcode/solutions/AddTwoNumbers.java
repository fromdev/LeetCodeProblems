package com.fromdev.leetcode.solutions;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = newListNode(9004);
        ListNode l2 = newListNode(119876);
        ListNode sum = addTwoNumbers.addTwoNumbers(l1,l2);
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
}

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


