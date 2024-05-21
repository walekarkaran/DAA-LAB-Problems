import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int target) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        // Binary search to find the closest element to the target
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                left = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Initialize pointers based on the position of the closest element found
        int l = left - 1;
        int r = left;

        // Find k closest elements using two pointers approach
        while (k > 0) {
            if (l < 0 || (r < arr.length && Math.abs(arr[l] - target) > Math.abs(arr[r] - target))) {
                result.add(arr[r]);
                r++;
            } else {
                result.add(arr[l]);
                l--;
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 17, 18, 20, 25};
        int k1 = 4;
        int target1 = 19;
        System.out.println("Closest elements to target " + target1 + ": " + findClosestElements(arr, k1, target1));

        int k2 = 3;
        int target2 = 1;
        System.out.println("Closest elements to target " + target2 + ": " + findClosestElements(arr, k2, target2));

        int k3 = 2;
        int target3 = 8;
        System.out.println("Closest elements to target " + target3 + ": " + findClosestElements(arr, k3, target3));
    }
}
