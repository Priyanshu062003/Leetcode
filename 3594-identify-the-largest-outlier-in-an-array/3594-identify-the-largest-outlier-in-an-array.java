class Solution {
    public int getLargestOutlier(int[] nums) {
        int ans = -10000;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i: nums) {
            sum += i;
            map.put(i,map.getOrDefault(i,0)+1);
        } 
        System.out.println(sum);
        for(int i=0; i<n; i++) {
            if((sum - nums[i])%2 == 0 && map.containsKey((sum - nums[i])/2)) {
                if(nums[i] == (sum - nums[i])/2 && map.get(nums[i]) <=1) continue;
                ans = Math.max(ans,nums[i]);  
                System.out.println(nums[i]);
            } 
        }
        

        return ans;
    }
}