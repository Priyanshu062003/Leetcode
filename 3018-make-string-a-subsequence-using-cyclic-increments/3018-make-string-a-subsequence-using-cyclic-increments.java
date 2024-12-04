class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if(m>n) return false;
        int j=0;
        for(int i=0; i<n&& j<m; i++) {
            char c = str1.charAt(i);
            char ch = str2.charAt(j);
            if((c == 'z' && ch == 'a' )||ch-c == 1 || c == ch) 
                j++;
                
        }
        return j==m;
    }
}