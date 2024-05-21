public class OptimalBinarySearchTree {

    public static int optimalBST(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] dp = new int[n][n];

        // Building the dp table bottom-up
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = sum(freq, i, j);

                for (int k = i; k <= j; k++) {
                    int cost = sum + (k - 1 < i ? 0 : dp[i][k - 1]) + (k + 1 > j ? 0 : dp[k + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
    }

    private static int sum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] keys = {10, 20, 30, 40, 50, 60, 70};
        int[] freq = {4, 2, 6, 3, 1, 5, 7};
        System.out.println("Minimum cost to construct optimal BST: " + optimalBST(keys, freq));
    }
}
