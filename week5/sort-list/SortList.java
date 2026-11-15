public class SortList {

    // тот же merge sort, только середину ищем медленным и быстрым указателями
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // fast идёт в два раза быстрее, поэтому когда он в конце, slow на середине
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        // ищу узел перед серединой и разрываю список на две половины,
        // иначе рекурсия будет крутиться бесконечно
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == mid) {
                curr.next = null;
                break;
            }
            curr = curr.next;
        }

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    // сливает два отсортированных списка в один отсортированный
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3,
                new ListNode(4, new ListNode(0)))));

        ListNode sorted = new SortList().sortList(head);
        // должно быть -1 0 3 4 5
        for (ListNode curr = sorted; curr != null; curr = curr.next) {
            System.out.print(curr.val + " ");
        }
        System.out.println();
    }
}
