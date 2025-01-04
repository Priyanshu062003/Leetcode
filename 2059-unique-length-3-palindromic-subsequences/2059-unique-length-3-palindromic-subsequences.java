class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        int n = s.length();
        Arrays.fill(first,n);

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            first[c-'a'] = Math.min(i,first[c-'a']);
            last[c-'a'] = i;
        }
        int ans = 0;
        
        for(int i=0; i<26; i++) {
            Set<Character> set = new HashSet<>();
            for(int j= first[i]+1; j<last[i]; j++) 
                set.add(s.charAt(j));
            ans += set.size();
        }
        return ans;


    }
}