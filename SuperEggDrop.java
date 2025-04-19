
// Problem1: Super Egg Drop (https://leetcode.com/problems/super-egg-drop/)

// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, max no.of attempts possible are n in worst case so lets try to fill matrix of attempts on rows and eggs on columns with max floors
 * can be reached. If dp[attempts][k] reaches n then return attempts.
 */

class SuperEggDrop {
    public int superEggDrop(int k, int n) {


        int[][] dp = new int[n+1][k+1];
        int attempts = 0;

        while(dp[attempts][k] < n) {
            attempts++;

            for(int j = 1; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];

            }
        }

        return attempts;
    }
}