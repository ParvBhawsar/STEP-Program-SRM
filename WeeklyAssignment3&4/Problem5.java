public class Problem5 {
    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};
        String target = "accB";

        // Linear Search
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals(target)) {
                System.out.println("Linear Search Found at index: " + i);
                break;
            }
        }

        // Binary Search
        int low = 0, high = logs.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = logs[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Search Found at index: " + mid);
                break;
            } else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
    }
}