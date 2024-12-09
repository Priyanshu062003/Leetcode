class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int pre[] = new int[n];
        boolean ans[] = new boolean[queries.length];

        pre[0] = 0;
        for(int i=1; i<n; i++) {
            if((nums[i]+nums[i-1])%2 == 1) pre[i] = pre[i-1];
            else pre[i] = pre[i-1]+1;
        }
        for(int i=0; i<queries.length; i++) {
            ans[i] = (pre[queries[i][0]] == pre[queries[i][1]]);
        }
        return ans;
    }
}