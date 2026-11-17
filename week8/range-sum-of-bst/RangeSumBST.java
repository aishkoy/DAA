public class RangeSumBST {

    // пользуемся тем, что это BST: если узел меньше low, всё его левое поддерево тоже меньше,
    // туда можно не ходить (и наоборот для high)
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high); // слева только ещё меньше
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high); // справа только ещё больше
        }
        // узел в диапазоне, считаем его и обе стороны
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        // дерево [10,5,15,3,7,null,18]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        RangeSumBST solution = new RangeSumBST();
        System.out.println(solution.rangeSumBST(root, 7, 15)); // 32 = 7 + 10 + 15
    }
}
