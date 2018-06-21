class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // boolean canBreak = false;
        // for(String word : wordDict) {
        //     if(s.startsWith(word) && s.length() > word.length()) {
        //         return wordBreakRec(s.substring(word.length()), wordDict);
        //     }
        // }
        // return false;
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

    public boolean wordBreakRec(String s, List<String> wordDict) {
        boolean canBreak = false;
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                if(s.length() == word.length()) {
                    return true;
                } else {
                    return wordBreakRec(s.substring(word.length()), wordDict);
                }
            }
        }
        return false;
    }

}
