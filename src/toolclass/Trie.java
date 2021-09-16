package toolclass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/9/16 10:02
 */
public class Trie {
    public String word;
    public Map<Character, Trie> children;
    public boolean isWord;

    public Trie() {
        this.word = "";
        this.children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}
