public class RemoveElements {

    // фиктивный узел перед head, чтобы удаление головы ничем не отличалось от остальных
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // выкидываем следующий узел
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6, new ListNode(1, new ListNode(2, new ListNode(6,
                new ListNode(3, new ListNode(6))))));

        ListNode result = new RemoveElements().removeElements(head, 6);
        // должно быть 1 2 3
        for (ListNode curr = result; curr != null; curr = curr.next) {
            System.out.print(curr.val + " ");
        }
        System.out.println();
    }
}
