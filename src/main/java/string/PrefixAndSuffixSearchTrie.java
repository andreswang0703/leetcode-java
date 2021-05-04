package string;


class PrefixAndSuffixSearchTrie {
    private TrieNode root = new TrieNode(' ');

    public PrefixAndSuffixSearchTrie(String[] words) {

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            String full = word + "{" + word;

            for (int i = 0; i < full.length(); i++) {
                String st = full.substring(i);
                TrieNode cur = root;
                for (int j = 0; j < st.length(); j++) {
                    char c = st.charAt(j);
                    int idx = c - 'a';
                    if (cur.children[idx] == null) {
                        cur.children[idx] = new TrieNode(c);
                    }
                    cur.index = index;
                    cur = cur.children[idx];
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = root;
        String s = suffix + "{" + prefix;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                System.out.println(idx);
                return -1;
            }
            cur = cur.children[idx];
        }
        return cur.index;
    }

    class TrieNode {
        private char val;
        private int index;
        private TrieNode children[] = new TrieNode[27];
        TrieNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple"};
        PrefixAndSuffixSearchTrie solver = new PrefixAndSuffixSearchTrie(words);
        System.out.println(solver.f("a", "e"));
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
