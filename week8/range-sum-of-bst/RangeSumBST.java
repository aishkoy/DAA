public class RangeSumBST {

    // обхожу всё дерево и складываю только те узлы, которые попадают в [low, high]
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val; // узел в диапазоне
        }
        // в обе стороны иду всегда, даже если узел вне диапазона
        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);
        return sum;
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
        System.out.println(solution.rangeSumBST(root, 6, 10)); // 17 = 7 + 10
    }
}
