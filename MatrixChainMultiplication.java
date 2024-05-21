public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];

        // Initializing the dp table
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Building the dp table bottom-up
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 100, 5, 500};
        System.out.println("Minimum cost of matrix chain multiplication: " + matrixChainOrder(dimensions));
    }
}
