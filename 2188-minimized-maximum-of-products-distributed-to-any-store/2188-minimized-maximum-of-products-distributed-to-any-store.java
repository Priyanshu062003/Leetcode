class Solution {
    boolean isValid(int t, int n, int []q) {
        int count = 0;
        for(int i: q) {
            count += i/t;
            count += i%t == 0? 0: 1;
        }
        return count<=n;
    }
    public int minimizedMaximum(int n, int[] q) {
        int l = 1;
        int r = 1;
        int m = q.length;

        for(int i: q) r = Math.max(r,i);
        while(l<=r) {
            int mid = (l+r)/2;
            if(isValid(mid,n,q)) {
                r = mid -1;
            }else l = mid+1;
        }

        return l;
    }
}