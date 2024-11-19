class Solution {
    public int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        int ans = 0, count = 0;
        boolean found = false;
        for (int num : nums) {
            if (num < k) {
                --count;
            }else if (num > k) {
                ++count;
            }else {
                found = true;
            }
            if (found) {
                ans += map.getOrDefault(count, 0) + map.getOrDefault(count - 1, 0);
            }else {
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }
        return ans;
    }
}