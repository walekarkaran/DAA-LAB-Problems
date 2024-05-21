import java.util.Arrays;

public class PairWithDifferenceK {

    public static void findPairsWithDifferenceK(int[] arr, int k) {
        Arrays.sort(arr); // Sort the array in non-decreasing order
        int left = 0;
        int right = 1;

        while (right < arr.length) {
            int diff = arr[right] - arr[left];
            if (diff == k) {
                System.out.println("(" + arr[left] + ", " + arr[right] + ")");
                left++;
                right++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 2, 2, 5, 5, 4};
        int k = 3;
        System.out.println("Pairs with difference " + k + " are:");
        findPairsWithDifferenceK(arr, k);
    }
}
