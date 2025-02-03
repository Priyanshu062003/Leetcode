class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int n = nums.length; 
        int temp = 1;
        for(int i=1; i<n; i++) {
            if(nums[i]>nums[i-1]) {
                temp++;
                ans = Math.max(temp,ans);
            }else {
                temp = 1;
            }
        }
        temp = 1;
        for(int i= n-2; i>=0; i--) {
            if(nums[i]>nums[i+1]) {
                temp++;
                ans = Math.max(ans,temp);
            }else {
                temp = 1;
            }
        }
        return ans;
    }
}