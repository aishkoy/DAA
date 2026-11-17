import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBST {

    // корнем делаем середину массива: слева меньшие, справа большие,
    // и половины получаются одинаковые, поэтому дерево сбалансировано
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // строю дерево из куска nums[left..right], массив не копирую
    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null; // кусок пустой
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    // inorder у BST должен дать исходный отсортированный массив
    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode root = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        System.out.println(root.val); // 0, середина массива
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list); // [-10, -3, 0, 5, 9]
    }
}
