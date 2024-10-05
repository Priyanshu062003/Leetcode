class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int ans[] = new int[m];

        for(int i=0; i<m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int ca = 0;
            int cb = 0;

            while(a != b) {
                if(a > b) {
                    a /= 2;
                    ca++;
                }else {
                    b /= 2;
                    cb++;
                }
            }
            ans[i] = ca+cb+1;
        }
        return ans;

    }
}