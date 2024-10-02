class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long l = 1, r = Long.MAX_VALUE;
        int A = a, B = b;
        while (B > 0) {
            int tmp = A;
            A = B;
            B = tmp % B;
        }

        while(l<=r) {
            long mid = (l+r)/2;
            long sum = mid/a + mid/b - mid/(a*b/A);
            System.out.println(mid+" "+sum);
            if(sum >= n) r = mid -1;
            else l = mid+1;
        }
        System.out.println(l+" "+r);
        return (int)(l%(int)(1e9+7));
    }
}