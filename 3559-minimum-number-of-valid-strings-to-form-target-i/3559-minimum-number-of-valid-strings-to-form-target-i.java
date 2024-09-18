class TrieNode {
    TrieNode[] childs;
    TrieNode() {
        this.childs = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    Trie() {
        this.root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (temp.childs[idx] == null) {
                temp.childs[idx] = new TrieNode();
            }
            temp = temp.childs[idx];
        }
    }
}

class Solution {
    int n;
    String target;
    int[] dp;

    private int solve(int i, TrieNode root) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];
        
        TrieNode temp = root;
        int res = 100001;

        for (int j = i; j < n; j++) {
            int idx = target.charAt(j) - 'a';
            if (temp.childs[idx] == null) break;
            temp = temp.childs[idx];
            res = Math.min(res,solve(j+1,root)+1);
        }
        return dp[i] = res;
    }

    public int minValidStrings(String[] words, String target) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        this.n = target.length();
        this.target = target;
        this.dp = new int[n];
        Arrays.fill(dp, -1);

        int res = solve(0, trie.root);
        return res >= 100001 ? -1 : res;
    }
}