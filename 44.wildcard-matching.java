/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    int dp[][];

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return wildcardMatch(s, p, m, n) == 1 ? true : false;
    }

    public int wildcardMatch(String s, String p, int i, int j) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == 0 && j == 0) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        if (i == 0 && j > 0) {
            if (p.charAt(j - 1) == '*') {
                dp[i][j] = wildcardMatch(s, p, i, j - 1);
            }

            else {
                dp[i][j] = 0;
            }
            return dp[i][j];
        }
        if (i > 0 && j == 0) {
            dp[i][j] = 0;
            return dp[i][j];
        }
        if (p.charAt(j - 1) == '*') {
            dp[i][j] = (wildcardMatch(s, p, i - 1, j) +
                    wildcardMatch(s, p, i, j - 1) +
                    wildcardMatch(s, p, i - 1, j - 1)) >= 1 ? 1 : 0;
            return dp[i][j];
        }
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            dp[i][j] = wildcardMatch(s, p, i - 1, j - 1);
            return dp[i][j];
        }
        dp[i][j] = 0;
        return dp[i][j];
    }
}
// @lc code=end
