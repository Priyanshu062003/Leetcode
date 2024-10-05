class Solution {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character , Integer> m1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            m1.put(ch,m1.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<=s2.length()-s1.length(); i++) {
            Map<Character , Integer> m2 = new HashMap<>();
            for (int j = i; j < i+s1.length(); j++) {
                char ch = s2.charAt(j);
                m2.put(ch, m2.getOrDefault(ch,0)+1);
            }
            if(m1.equals(m2) ) {
                return true;
            }
        }
        return false;

    }
}