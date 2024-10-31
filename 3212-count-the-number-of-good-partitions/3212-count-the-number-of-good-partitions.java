class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int mod = 1000000007;

        for(int i=0; i<n; i++) {
            map.put(nums[i],i);
        }
        int partition = 0;

        for(int i=0; i<n; i++) {
            int next = map.get(nums[i]);
            for(;i<next; i++) {
                next = Math.max(next,map.get(nums[i]));
            }
            partition++;
        }
        int ans = 1;
        for(int i=1; i<partition; i++)
            ans = (ans*2)%mod;

        return ans;
        // 12 1,2

    }
}