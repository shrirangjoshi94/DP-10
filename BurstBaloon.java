// Problem2: Burst Balloon (https://leetcode.com/problems/burst-balloons/)

// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take all possibilities of having one subsets, 2 subsets, 3 subsets etc, then for each find left + burstible arrays calculation + right
 * for rach burstible array calculation, take element * nums[i-1] * nums[j+1]. Finally retutn dp[0][n-1].
 */

class BurstBaloon {
    public int maxCoins(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] dp = new int[n][n];


        // bustible arr
        for(int le = 1; le <= n; le++) {
            // start of the bustible arr i is start of bustible arr
            for(int i = 0; i <= n - le; i++) {

                // end of the bustible arr
                int j = i + le - 1;
                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    // kth baloon in end

                    int left = 0;

                    if(i != k) {
                        left = dp[i][k-1];
                    }

                    int right = 0;

                    if(j != k) {
                        right = dp[k+1][j];
                    }

                    // kth
                    int before = 1;

                    if(i != 0) {
                        before = nums[i-1];
                    }

                    int after = 1;

                    if(j != n-1) {
                        after = nums[j+1];
                    }

                    // left already burst + before  * kth* after + right already burst
                    int curr = left + (before * nums[k] * after) + right;
                    max = Math.max(max, curr);
                }

                dp[i][j] = max;
            }
        }


        return dp[0][n-1];
    }
}