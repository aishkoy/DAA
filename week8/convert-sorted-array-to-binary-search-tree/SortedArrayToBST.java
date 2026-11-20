import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST {

    // корень - середина массива, слева от неё меньшие числа, справа большие,
    // и половины одинакового размера, поэтому дерево получается сбалансированным
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // копирую левую и правую половины в отдельные массивы и строю из них поддеревья
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
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

        System.out.println(root.val + " " + root.left.val + " " + root.right.val); // 0 -3 9
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list); // [-10, -3, 0, 5, 9]

        TreeNode small = solution.sortedArrayToBST(new int[]{1, 3});
        System.out.println(small.val + " " + small.left.val); // 3 1
    }
}
