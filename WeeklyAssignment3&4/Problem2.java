class Problem2 {
    public static void main(String[] args) {
        int[] risk = {80, 20, 50};

        // Bubble Sort ascending
        for (int i = 0; i < risk.length - 1; i++) {
            for (int j = 0; j < risk.length - i - 1; j++) {
                if (risk[j] > risk[j + 1]) {
                    int temp = risk[j];
                    risk[j] = risk[j + 1];
                    risk[j + 1] = temp;
                }
            }
        }

        System.out.print("Bubble Asc: ");
        for (int x : risk) System.out.print(x + " ");

        // Insertion Sort descending
        for (int i = 1; i < risk.length; i++) {
            int key = risk[i];
            int j = i - 1;
            while (j >= 0 && risk[j] < key) {
                risk[j + 1] = risk[j];
                j--;
            }
            risk[j + 1] = key;
        }

        System.out.print("\nInsertion Desc: ");
        for (int x : risk) System.out.print(x + " ");
    }
}