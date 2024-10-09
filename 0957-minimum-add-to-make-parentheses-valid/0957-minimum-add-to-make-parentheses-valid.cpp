class Solution {
public:
    int minAddToMakeValid(string s) {
        int ans = 0;
        int count = 0;
        for(int i=0; i<s.size(); i++) {
            if(s[i]==')' && count == 0)
                ans++;
            else if(s[i]=='(')
                count++;
            else 
                count--;
        }
        return ans+count;
    }
};