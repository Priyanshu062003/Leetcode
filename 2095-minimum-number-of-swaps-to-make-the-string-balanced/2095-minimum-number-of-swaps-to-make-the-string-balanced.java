class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(st.isEmpty() || st.peek() == ']' || c == '[') 
                st.add(c);
            else 
                st.pop();
        }
        return (st.size()/2+1)/2;

    }
}