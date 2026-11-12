import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {

    // первое решение: запоминаю все узлы списка A и ищу первый узел B, который там уже есть
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visitedA = new HashSet<>();
        for (ListNode currA = headA; currA != null; currA = currA.next) {
            visitedA.add(currA);
        }
        for (ListNode currB = headB; currB != null; currB = currB.next) {
            if (visitedA.contains(currB)) {
                return currB;
            }
        }
        return null;
    }

    // второе решение, придумала не сама, но разобралась:
    // каждый указатель проходит A + B, поэтому оба делают одинаковое число шагов
    // и встречаются в точке пересечения (или оба в null, если её нет)
    public ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while (curr1 != curr2) {
            curr1 = curr1 != null ? curr1.next : headB;
            curr2 = curr2 != null ? curr2.next : headA;
        }
        return curr1;
    }

    public static void main(String[] args) {
        // общая часть 8 -> 4 -> 5
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, common));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        IntersectionNode solution = new IntersectionNode();
        System.out.println(solution.getIntersectionNode(headA, headB).val); // 8
        System.out.println(solution.getIntersectionNodeTwoPointers(headA, headB).val); // 8

        ListNode other = new ListNode(2);
        System.out.println(solution.getIntersectionNode(headA, other)); // null
        System.out.println(solution.getIntersectionNodeTwoPointers(headA, other)); // null
    }
}
