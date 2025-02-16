class Solution {
    int N;
    boolean solve(int i, int[] ans, boolean[] visit) {
        if(i == ans.length) {
            System.out.println(Arrays.toString(ans));
            return true;
        } 

        if(ans[i] != 0) return solve(i+1,ans,visit);
        for(int j=N; j>0; j--) {
            if(visit[j]) continue;
            visit[j] = true;
            ans[i] = j;
            if(j == 1) {
                if(solve(i+1,ans,visit)) return true;
            }
            else if(i+j < ans.length && ans[i+j] == 0){
                ans[i+j] = j;
                if(solve(i+1,ans,visit)) return true;
                ans[i+j] = 0;
            }  
            ans[i] = 0;
            visit[j] = false;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int ans[] = new int[2*n-1];
        N = n;
        boolean visit[] = new boolean[n+1];
        solve(0,ans,visit);
        return ans;
    }
}