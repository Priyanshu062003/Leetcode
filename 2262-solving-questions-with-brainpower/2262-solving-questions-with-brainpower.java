class Solution {
    int n;
    long solve(int i,int[][] q,long[] memo){
        if(i>=n)return 0;
        if(memo[i]!=-1)return memo[i];
        return memo[i]=Math.max(q[i][0]+solve(i+q[i][1]+1,q,memo),solve(i+1,q,memo));
    }
    public long mostPoints(int[][] q) {
        n=q.length;
        long memo[]=new long [n+1];
        Arrays.fill(memo,-1);
        return solve(0,q,memo);
    }
}