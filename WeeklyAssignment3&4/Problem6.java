public class Problem6 {
    public static void main(String[] args) {
        int[] risk = {10, 25, 50, 100};
        int target = 30;

        int low = 0, high = risk.length - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (risk[mid] == target) {
                floor = ceil = risk[mid];
                break;
            } else if (risk[mid] < target) {
                floor = risk[mid];
                low = mid + 1;
            } else {
                ceil = risk[mid];
                high = mid - 1;
            }
        }

        System.out.println("Floor = " + floor);
        System.out.println("Ceiling = " + ceil);
    }
}