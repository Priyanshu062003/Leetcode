class Solution {
    public boolean check(int[] nums) {
        int rotation=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                rotation++;
                if(rotation>1){
                    return false;
                }
            }
        }
        if(rotation==1){
            if(nums[n-1]<=nums[0])return true;
            return false;
        }
        return true;
    }
}