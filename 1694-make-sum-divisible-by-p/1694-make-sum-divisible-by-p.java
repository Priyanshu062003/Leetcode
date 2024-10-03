class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0; int n = nums.length;
        int ans = n;
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,-1);
        for(int i=0; i<n; i++) {
            sum = (sum+nums[i])%p;
        }

        int rem = sum % p;
        if(rem == 0) return 0;

        sum = 0;
        for(int i=0; i<n; i++) {
            sum = (sum + nums[i])%p;
            int remain = (sum - rem +p)%p;
            prefix.put(sum,i);
            ans = Math.min(ans,i - prefix.getOrDefault(remain,-1000000));
        }
        return ans<n ? ans : -1;
    }
}