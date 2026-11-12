import java.util.ArrayList;
import java.util.List;

public class PalindromeList {

    // по списку назад не пройти, поэтому переписываю значения в массив
    // и сравниваю двумя указателями с концов
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            arr.add(curr.val);
        }

        int start = 0;
        int end = arr.size() - 1;
        while (start <= end) {
            // equals, а не ==, потому что в списке лежат Integer
            if (!arr.get(start).equals(arr.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeList solution = new PalindromeList();
        ListNode yes = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode no = new ListNode(1, new ListNode(2));
        System.out.println(solution.isPalindrome(yes)); // true
        System.out.println(solution.isPalindrome(no)); // false
    }
}
