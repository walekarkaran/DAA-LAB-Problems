import java.util.Arrays;

public class SubsetSum {

    public static boolean subsetSum(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][k + 1];

        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Building the dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int[] A = {7, 3, 2, 5, 8};
        int k = 14;
        if (subsetSum(A, k)) {
            System.out.println("Subset with the given sum exists");
            System.out.println("Subset: " + Arrays.toString(getSubset(A, k)));
        } else {
            System.out.println("No subset with the given sum exists");
        }
    }

    public static int[] getSubset(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][k + 1];
        StringBuilder subset = new StringBuilder();
        int i = n;
        while (i > 0 && k > 0) {
            if (nums[i - 1] <= k && dp[i][k] && !dp[i - 1][k]) {
                subset.insert(0, nums[i - 1] + " ");
                k -= nums[i - 1];
            }
            i--;
        }
        String[] subsetArray = subset.toString().split(" ");
        int[] result = new int[subsetArray.length];
        for (int j = 0; j < subsetArray.length; j++) {
            result[j] = Integer.parseInt(subsetArray[j]);
        }
        return result;
    }
}
