import java.util.Arrays;

public class SortArray {

    // обычный рекурсивный merge sort
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int mid = n / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, n));
        return merge(left, right);
    }

    // сливаю два отсортированных массива в один
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int k = 0;

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] < right[rightPointer]) {
                result[k++] = left[leftPointer++];
            } else {
                result[k++] = right[rightPointer++];
            }
        }
        // докидываем то, что осталось в одной из половин
        while (leftPointer < left.length) {
            result[k++] = left[leftPointer++];
        }
        while (rightPointer < right.length) {
            result[k++] = right[rightPointer++];
        }
        return result;
    }

    public static void main(String[] args) {
        SortArray solution = new SortArray();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1}))); // [1, 2, 3, 5]
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 1, 1, 2, 0, 0}))); // [0, 0, 1, 1, 2, 5]
    }
}
