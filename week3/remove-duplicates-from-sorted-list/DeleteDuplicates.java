public class DeleteDuplicates {

    // список отсортирован, значит одинаковые значения стоят подряд
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // перепрыгиваем дубликат, curr не двигаем
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3)))));

        ListNode result = new DeleteDuplicates().deleteDuplicates(head);
        // должно быть 1 2 3
        for (ListNode curr = result; curr != null; curr = curr.next) {
            System.out.print(curr.val + " ");
        }
        System.out.println();
    }
}
