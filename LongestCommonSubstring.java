public class LongestCommonSubstring {

    public static int longestCommonSubstring(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        // Building the dp table bottom-up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0; // Resetting length for non-matching characters
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String X = "ABABC";
        String Y = "BABCA";
        System.out.println("Length of Longest Common Substring: " + longestCommonSubstring(X, Y));
    }
}
