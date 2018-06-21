class Solution {
    
    // int[] wordLetters = new int[26];
    int[] dictLetters = new int[26];
    HashSet<String> dictSet = new HashSet<String>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(!optimize(s, wordDict)) return false;
        return wordBreakRec(s, new ArrayList<String>(dictSet));
            
//        return wordBreakRec(s, wordDict); // recursive
//        return wordBreakHash(s, wordDict);
    }

    public boolean optimize(String s, List<String> wordDict) {
        for(String word : wordDict) {
            dictSet.add(word);
            addToLetterArray(word, dictLetters);
        }
        for(String word : wordDict) {
            dictSet.remove(word);
            System.out.println("removed:"+word);
            if(!wordBreakHashRec(word, dictSet)) {
                dictSet.add(word);
                System.out.println("added:" + word);
            }
        }
        System.out.println("Done optimize:"+dictSet);
        if(!letterCheck(s)) return false;
        return true;
        //return wordBreakHashRec(s, dictSet);
    }
    
    public boolean wordBreakHash(String s, List<String> wordDict) {
        HashSet dictSet = new HashSet();
        for(String word : wordDict) {
            dictSet.add(word);
            addToLetterArray(word, dictLetters);
        }
        for(String word : wordDict) {
            dictSet.remove(word);
            if(!wordBreakHashRec(word, dictSet)) {
                dictSet.add(word);
            }
        }
        System.out.println(dictSet);
        if(!letterCheck(s)) return false;
        return wordBreakHashRec(s, dictSet);
    }
    
    public boolean wordBreakHashRec(String s, Set dictSet) {
        for(int i=1; i <= s.length(); i++) {
            if(dictSet.contains(s.substring(0,i))) {
                if(i==s.length()) {
                    return true;
                } else {
                    String s2 = s.substring(i);
                    for(int j=s2.length()-1; j >= 0; j--) {
                        if(dictSet.contains(s2.substring(j))) {
                            if(j==0) {
                                return true;
                            } else if(wordBreakHashRec(s2.substring(0,j), dictSet)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void addToLetterArray(String s, int[] letterArray) {
        for(int i=0; i< s.length(); i++ ) {
            letterArray[s.charAt(i)-'a'] = 1;
        }
    }
    
    // all letters in the word must exist in dictionary letters.
    public boolean letterCheck(String s) {
        for(int i=0; i< s.length(); i++ ) {
            if(dictLetters[s.charAt(i)-'a'] == 0) {
                return false;
            }
        }
        return true;
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
