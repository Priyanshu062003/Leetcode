class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];

        for(int i=0; i<n; i++) {
            int num = nums.get(i);

            if(num == 2) {
                ans[i] = -1;
                continue;
            }
            int count = 0;
            while(num%2 == 1) {
                count++;
                num/=2;
            }
            ans[i] = nums.get(i) - (int)Math.pow(2,count-1);
        }
        return ans;
    }
}