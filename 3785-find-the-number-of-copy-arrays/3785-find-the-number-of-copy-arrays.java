class Solution {
    public int countArrays(int[] arr, int[][] bounds) {
        int n = arr.length;
        int l = bounds[0][0], h = bounds[0][1];
        int ans = h - l + 1;

        for(int i=1; i<n; i++) {
            int diff = arr[i] - arr[i-1];
            l = Math.max(l+diff,bounds[i][0]);
            h = Math.min(h+diff,bounds[i][1]);
            ans = Math.min(ans, h-l+1);
            System.out.println(h+" "+ans+" "+l);
        }
        return Math.max(ans,0);
    }
}