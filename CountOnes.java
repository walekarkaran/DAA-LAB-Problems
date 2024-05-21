public class CountOnes {

    public static int countOnes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        int result =nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == 1) {
                result = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            } 
        }
        return nums.length -result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1};

        System.out.println("The total number of 1's is: " + countOnes(nums1));
        System.out.println("The total number of 1's is: " + countOnes(nums2));
    }
}
