class Solution {
    
    public boolean parseBoolExpr(String exp) {
        int n = exp.length();
        Stack<Character> st = new Stack<>();

        for(char c: exp.toCharArray()) {
            if(c == ',') continue;
            if(c == ')') {
                Set<Character> set = new HashSet<>();
                while(st.peek() != '(') set.add(st.pop());
                st.pop();
                char opr = st.pop();
                if(opr == '|') 
                    st.add(set.contains('t')? 't':'f');
                else if(opr=='&') 
                    st.add(set.contains('f')? 'f':'t');
                else 
                    st.add(set.contains('t')? 'f':'t');
            }
            else st.add(c);
        }
        return st.peek() == 't';
    }
}