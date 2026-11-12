public class MergeTwoLists {

    // берём меньшую из двух голов, а её хвост — это слияние всего остального
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = new MergeTwoLists().mergeTwoLists(list1, list2);
        // должно быть 1 1 2 3 4 4
        for (ListNode curr = merged; curr != null; curr = curr.next) {
            System.out.print(curr.val + " ");
        }
        System.out.println();
    }
}
