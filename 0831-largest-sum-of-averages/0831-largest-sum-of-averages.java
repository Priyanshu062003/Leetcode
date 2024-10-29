class Solution {
    int n;
    double dp[][];
    double solve(int i,int k, int[] nums, int[] preSum) {
        if(i == n) return 0.0;
        if(k == 1) return (preSum[n-1]-preSum[i]+nums[i])/(n-1 - i+1.0);
        double ans = 0.0;
        if(dp[i][k] != -1.0) return dp[i][k];

        for(int j=i;j<n-k+1; j++) {
            double avg = (preSum[j]-preSum[i]+nums[i])/(j-i+1.0);
            // System.out.println(i+" "+prev+" "+avg);
            ans = Math.max(ans,solve(j+1,k-1,nums,preSum)+avg);
        }
        return dp[i][k] = ans;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        n = nums.length;
        int preSum[] = new int[n];
        dp = new double[n][k+1];
        for(double i[]: dp)
            Arrays.fill(i,-1.0);
        preSum[0] = nums[0];
        for(int i=1; i<n; i++) {
            preSum[i] = nums[i]+preSum[i-1];
        }
        return solve(0,k,nums,preSum);
    }
}