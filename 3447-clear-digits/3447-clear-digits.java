class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        int a = -1;
        int b = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c >= '0' &&  c <= '9') {
                if(!st.isEmpty())
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        String ans = "";
        while (!st.isEmpty()) {
            char c = st.pop();
            ans = c+ans;
        }
        return ans;

        
    }
}