class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Long ans = 0L;
        Long temp = 0L;
        int start = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int end=0; end<n; end++) {
            while(end-start+1 > k) {
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                temp = (temp-nums[start++]);
            }
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            temp = (temp+nums[end]);
            while(map.get(nums[end])>1) {
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                temp = (temp-nums[start++]);
            }
            if(end-start+1 == k) ans = Math.max(temp,ans);
        }
        return ans;
    }
}