class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //return wordBreakRec(s, wordDict); // recursive
        return wordBreakHash(s, wordDict);
    }

    public boolean wordBreakHash(String s, List<String> wordDict) {
        HashSet dictSet = new HashSet();
        for(String word : wordDict) {
            dictSet.add(word);
        }
        return wordBreakHashRec(s, dictSet);
    }
    
    public boolean wordBreakHashRec(String s, Set dictSet) {
        for(int i=1; i <= s.length(); i++) {
            if(dictSet.contains(s.substring(0,i))) {
                if(i==s.length()) {
                    return true;
                } else {
                    if(wordBreakHashRec(s.substring(i), dictSet)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean wordBreakRec(String s, List<String> wordDict) {
        boolean canBreak = false;
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                if(s.length() == word.length()) {
                    return true;
                } else {
                    if(wordBreak(s.substring(word.length()), wordDict)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
