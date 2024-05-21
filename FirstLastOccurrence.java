public class FirstLastOccurrence {

    public static int firstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + right / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Move to the left side to find the first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int lastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + right / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Move to the right side to find the last occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target = 5;
        int firstIndex = firstOccurrence(nums, target);
        int lastIndex = lastOccurrence(nums, target);
        
        if (firstIndex != -1) {
            System.out.println("The first occurrence of element " + target + " is located at index " + firstIndex);
            System.out.println("The last occurrence of element " + target + " is located at index " + lastIndex);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
