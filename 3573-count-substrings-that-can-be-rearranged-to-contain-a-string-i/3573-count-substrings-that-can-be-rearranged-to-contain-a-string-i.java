class Solution {
    public long validSubstringCount(String word1, String word2) {
        long ans = 0L; int n = word1.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char c: word2.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        
        int start = 0; 
        for(int end=0; end<n; end++) {
            char c = word1.charAt(end);
            if(map.containsKey(c)) {
                if(map.get(c) == 1)
                    count--;
                map.put(c,map.get(c)-1);
            }
            while(count==0 && start<=end) {
                char ch = word1.charAt(start);
                if(map.containsKey(ch)) {
                    map.put(ch,map.get(ch)+1);
                    if(map.get(ch)==1)
                        count++;
                }
                ans += n - end ;
                System.out.println(ans+" "+end);
                start++;
            }
        }
        return ans;
    }
}