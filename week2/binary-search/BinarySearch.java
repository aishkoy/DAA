public class BinarySearch {

    // каждый раз смотрим на середину и выкидываем ту половину, где target быть не может
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middleIdx = (left + right) / 2;
        int middleNumber = nums[middleIdx];

        while (true) {
            // осталось два элемента, проверяем оба руками
            if (right - left == 1) {
                if (nums[left] == target) {
                    return left;
                }
                if (nums[right] == target) {
                    return right;
                }
                return -1;
            }
            // остался один элемент
            if (right - left == 0) {
                return middleNumber == target ? middleIdx : -1;
            }
            if (target > middleNumber) {
                left = middleIdx + 1; // target правее середины
            }
            if (target < middleNumber) {
                right = middleIdx; // target левее, середину оставляем в границах
            }
            if (target == middleNumber) {
                return middleIdx;
            }
            middleIdx = (left + right) / 2;
            middleNumber = nums[middleIdx];
        }
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(nums, 9)); // 4
        System.out.println(solution.search(nums, 2)); // -1
    }
}
