package august2020;

import java.util.HashMap;

public class WordDictionary {

    HashMap[] dictionary;

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();

        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));

//        wd.addWord("a");
//        wd.addWord("ab");
//        System.out.println(wd.search("a"));
//        System.out.println(wd.search("a."));
//        System.out.println(wd.search("ab"));
//        System.out.println(wd.search(".a"));
//        System.out.println(wd.search(".b"));
//        System.out.println(wd.search("ab."));
//        System.out.println(wd.search("."));
//        System.out.println(wd.search(".."));
    }

    public WordDictionary() {
        dictionary = new HashMap[26];
    }

    public void addWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            HashMap mapAtIndex = dictionary[ch - 97];
            if (mapAtIndex == null) {
                mapAtIndex = new HashMap<Integer, Boolean>();
                dictionary[ch - 97] = mapAtIndex;
            }
            if (i == word.length() - 1) {
                mapAtIndex.put(i, Boolean.TRUE);
            } else if (!mapAtIndex.containsKey(i)) {
                mapAtIndex.put(i, Boolean.FALSE);
            }
        }
    }

    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            boolean found = false;
            // wildcard search for a character at an index of the word.
            if (ch == '.') {
                for (int mapIndex = 0; mapIndex < 26; mapIndex++) {
                    HashMap mapAtIndex = dictionary[mapIndex];
                    if (mapAtIndex != null && mapAtIndex.containsKey(i)) {
                        found = (i == word.length() - 1) ? mapAtIndex.get(i) == Boolean.TRUE : true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            } else {
                HashMap mapAtIndex = dictionary[ch - 97];
                if (mapAtIndex != null && mapAtIndex.containsKey(i)) {
                    found = (i == word.length() - 1) ? mapAtIndex.get(i) == Boolean.TRUE : true;
                }
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
}
