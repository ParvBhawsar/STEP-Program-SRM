import java.util.Arrays;

public class Problem3 {
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r)
            temp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++)
            arr[l + i] = temp[i];
    }

    public static void main(String[] args) {
        int[] volume = {500, 100, 300};
        mergeSort(volume, 0, volume.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(volume));
    }
}