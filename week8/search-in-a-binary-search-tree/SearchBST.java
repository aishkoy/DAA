public class SearchBST {

    // пользуемся свойством BST: слева от узла всё меньше, справа всё больше,
    // поэтому на каждом шаге идём только в одну сторону
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null; // дошли до конца ветки, такого значения нет
        }
        if (root.val == val) {
            return root; // нашли, возвращаем узел вместе с его поддеревом
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
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
