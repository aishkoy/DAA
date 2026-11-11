public class FirstBadVersion {

    // на leetcode isBadVersion дают готовым, тут подменяю его полем
    private final int firstBad;

    FirstBadVersion(int firstBad) {
        this.firstBad = firstBad;
    }

    boolean isBadVersion(int version) {
        return version >= firstBad;
    }

    // тот же бинарный поиск, только ищем самую левую плохую версию
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left != right) {
            // не (left + right) / 2, иначе при n около 2^31 будет переполнение int
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle; // middle может быть и есть первая плохая
            } else {
                left = middle + 1; // все до middle включительно хорошие
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion(4).firstBadVersion(5)); // 4
        System.out.println(new FirstBadVersion(1).firstBadVersion(1)); // 1
        // проверка на переполнение
        System.out.println(new FirstBadVersion(1702766719).firstBadVersion(2126753390)); // 1702766719
    }
}
