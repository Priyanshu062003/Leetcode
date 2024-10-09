class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int count = 0;
        for(char c : s.toCharArray()) {
            if(count == 0 && c == ')')
                ans++;
            else if(c == ')')
                count--;
            else 
                count++;
        }
        ans = ans+count;
        return ans;
    }
}