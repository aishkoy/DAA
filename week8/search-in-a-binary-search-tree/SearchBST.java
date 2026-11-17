public class SearchBST {

    // как бинарный поиск: сравниваем с узлом и идём только в одну сторону
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null && curr.val != val) {
            curr = val < curr.val ? curr.left : curr.right;
        }
        return curr; // либо нашли узел, либо null
    }

    public static void main(String[] args) {
        // дерево [4,2,7,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchBST solution = new SearchBST();
        TreeNode found = solution.searchBST(root, 2);
        System.out.println(found.val + " " + found.left.val + " " + found.right.val); // 2 1 3
        System.out.println(solution.searchBST(root, 5)); // null
    }
}
