class Trie {
    Trie child[] = new Trie[26];
    int size = 0;
    Trie() {
        Arrays.fill(child,null);
    }
    
}
class Solution {
    void insert(String s,Trie node) {
        for(char c: s.toCharArray()) {
            if(node.child[c-'a'] != null) {
                node = node.child[c-'a'];
            }else {
                node.child[c-'a'] = new Trie();
                node = node.child[c-'a'];
            }
            node.size++;
        }
        System.out.println(node.size+" "+s);
    }
    int count(String s,Trie node) {
        int count = 0;
        for(char c: s.toCharArray()) {
            node = node.child[c-'a'];
            count += node.size;
        }
        System.out.println(count);
        return count;
    }
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        for(String s: words) {
            Trie node = root;
            insert(s,node);
        }
        int ans[] = new int[words.length];
        int idx = 0;
        for(String s: words) {
            Trie node = root;
            ans[idx++] = count(s,node);
        }

        return ans;
    }
}