class Solution {
    int n;
    int solve(int i, String s,HashSet<String> set) {
        if(i == n) return 0;
        int take = 0;

        for(int j=i+1; j<=n; j++) {
            String temp = s.substring(i,j);
            if(!set.contains(temp)) {
                set.add(temp);
                take = Math.max(take,1+solve(j,s,set));
                set.remove(temp);
            }
        }
        return take;
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        n = s.length();
        return solve(0,s,set);
    }
}