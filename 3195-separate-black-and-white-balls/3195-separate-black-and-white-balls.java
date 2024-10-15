class Solution {
    public long minimumSteps(String s) {
        long ans = 0L; int n = s.length();
        long one = 0; long zero = 0;
        for(char c: s.toCharArray()){
            if(c == '1') one++;
            else zero++;
        }
        long gap = 0;
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i) == '1') {
                ans += gap*one;
                one--;
                gap = 0;
            }else 
                gap++;
        }
        return ans;
    }
}