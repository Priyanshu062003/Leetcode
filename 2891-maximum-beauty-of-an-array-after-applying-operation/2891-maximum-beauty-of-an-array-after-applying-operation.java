class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int ans = 0; Arrays.sort(nums);

        for(int start = 0, end = 0; end<nums.length; end++) {
            while(nums[end]-nums[start] > 2*k) start++;
            ans = Math.max(ans,end-start+1);
        }
        return ans;
    }
}