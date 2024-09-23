class Solution {
    int n;
    int solve(int i,String s,Set<String>set,int []dp){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        String temp="";
        int ans=n;
        for(int j=i;j<n;j++){
            temp=temp+s.charAt(j);
            int a=(set.contains(temp))? 0:temp.length();
            int b=solve(j+1,s,set,dp);
            int t=a+b;
            ans=Math.min(ans,t);
        }
        return dp[i]=ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        n=s.length();
        Set<String>set=new HashSet<>();
        for(String st: dictionary)set.add(st);
        int dp[]=new int[51];
        Arrays.fill(dp,-1);
        return solve(0,s,set,dp);
    }
}