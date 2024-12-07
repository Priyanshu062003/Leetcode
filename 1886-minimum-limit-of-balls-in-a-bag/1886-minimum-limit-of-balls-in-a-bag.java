class Solution {
    boolean valid(int tar, int[] nums, int maxOp) {
        for(int i: nums) {
            maxOp -= i/tar;
            maxOp -= (i%tar != 0)? 1: 0;
            maxOp++;
        }
        return maxOp >=0;
    }
    public int minimumSize(int[] nums, int maxOp) {
        int l = 1, r = 0;
        for(int i: nums) r = Math.max(r,i);

        while(l<=r) {
            int mid = (l+r)/2;
            if(valid(mid,nums,maxOp))
                r = mid-1;
            else l = mid+1;
        }
        return l;

    }
}