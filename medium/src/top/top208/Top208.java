package top.top208;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top208
 * @create 2022-08-25-15:58
 */
public class Top208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
    }
}

/**
 * class Trie {
 * Map<String, Set<String>> trie;
 * <p>
 * public Trie() {
 * trie = new HashMap<>();
 * }
 * <p>
 * public void insert(String word) {
 * Set<String> strings = trie.computeIfAbsent(word.substring(0, 1), k -> new HashSet<>());
 * strings.add(word);
 * }
 * <p>
 * public boolean search(String word) {
 * Set<String> strings = trie.get(word.substring(0, 1));
 * return strings != null && strings.contains(word);
 * }
 * <p>
 * public boolean startsWith(String prefix) {
 * Set<String> strings = trie.get(prefix.substring(0, 1));
 * if (strings != null) {
 * for (String str : strings) {
 * if (prefix.length() <= str.length() && prefix.equals(str.substring(0, prefix.length()))) {
 * return true;
 * }
 * }
 * }
 * return false;
 * }
 * }
 **/
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = isPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie = isPrefix(prefix);
        return trie != null;
    }

    private Trie isPrefix(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (trie.children[index]==null){
                return null;
            }
            trie = trie.children[index];
        }
        return trie;
    }
}