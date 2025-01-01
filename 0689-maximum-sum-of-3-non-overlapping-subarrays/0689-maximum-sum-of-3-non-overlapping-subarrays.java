class Solution {
    int sub[],n,K;
    Integer dp[][];
    List<Integer> ans = new ArrayList<>();
    int helper(int i, int rem) {
        if(rem == 0) return 0;
        if(i>=sub.length) return Integer.MIN_VALUE;
        if(dp[i][rem] != null) return dp[i][rem];
        int take = sub[i]+helper(i+K,rem-1);
        int not = helper(i+1,rem);
        return dp[i][rem] = Math.max(take,not);
    }
    void solve(int i, int rem) {
        if(rem == 0) return;
        if(i >=sub.length) return; 
        int take = sub[i]+helper(i+K,rem-1);
        int not = helper(i+1,rem);
        if(take >= not) {
            ans.add(i);
            solve(i+K,rem-1);
        }else 
            solve(i+1,rem);
        return ;
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        n = nums.length;
        sub = new int[n-k+1];
        dp = new Integer[n-k+1][4];
        K = k;
        int sum = 0;
        int start = 0;
        for(int end = 0; end<n; end++) {
            sum += nums[end];
            if(end - start +1 == k) {
                sub[start] = sum;
                sum -= nums[start];
                start++;
            }
        }
        System.out.println(Arrays.toString(sub));

        solve(0,3);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}