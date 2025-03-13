class Solution {
    boolean valid(int[] nums,int mid, int[][] queries) {
        int n  = nums.length;
        int arr[] = new int[n+1];
        for(int j=0; j<=mid; j++) {
            int i[] = queries[j];
            arr[i[0]]+=i[2];
            arr[i[1]+1]-=i[2];
        }

        for(int i=1; i<n; i++) {
            arr[i] += arr[i-1];
        }
        // System.out.println(Arrays.toString(arr));
        for(int i=0; i<n; i++) {
            if(arr[i]<nums[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = queries.length;
        int l = 0, r = n-1;
        int ans = -1;
        boolean zero = true;
        for(int i: nums) if(i!=0) zero = false;
        if(zero) return 0;
        // System.out.println(l+" "+r);
        while(l<=r) {
            int mid = (l+r)/2;
            if(valid(nums,mid,queries)) {
              r = mid-1;
              ans = mid;
            //   System.out.println(true);  
            } 
            else l = mid+1;
            // System.out.println(mid);
        }
        if(ans == -1) return -1;
        return ans+1;
    }
}