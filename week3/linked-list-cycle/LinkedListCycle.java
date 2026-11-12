import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    // запоминаю все узлы, где уже была; если пришла в узел второй раз, значит есть цикл
    public boolean hasCycle(ListNode head) {
        return hasCycle(head, new HashSet<>());
    }

    private boolean hasCycle(ListNode head, Set<ListNode> visitedNodes) {
        if (head == null) {
            return false; // дошли до конца списка, цикла нет
        }
        if (visitedNodes.contains(head)) {
            return true;
        }
        visitedNodes.add(head);
        return hasCycle(head.next, visitedNodes);
    }

    public static void main(String[] args) {
        // 3 -> 2 -> 0 -> -4 -> (обратно в 2)
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(head)); // true

        ListNode noCycle = new ListNode(1, new ListNode(2));
        System.out.println(solution.hasCycle(noCycle)); // false
    }
}
