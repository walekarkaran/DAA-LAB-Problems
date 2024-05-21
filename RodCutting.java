public class RodCutting {

    public static int rodCutting(int[] lengths, int[] prices, int n) {
        int[] dp = new int[n + 1];

        // Building the dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j] + dp[i - (j + 1)]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 4;
        System.out.println("Maximum profit from rod cutting: " + rodCutting(lengths, prices, rodLength));
    }
}
