class Solution {
    
    // int[] wordLetters = new int[26];
    int minlen = 10000;
    int maxlen = 0;
    int[] dictLetters = new int[26];
    HashSet<String> dictSet = new HashSet<String>();
    int[] soln; 
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // test input
        //s= "catsandog";
        //wordDict = Arrays.asList(new String[]{"cats","dog","sand","and","cat"});
        
        soln = new int[s.length()];
        
        minlen = 1;
        maxlen = s.length();
        //optional optimization
        if(!optimize(s, wordDict)) {
            return false;
        }
        return wordBreakHashRec(s, dictSet, 0);
    }

    public boolean optimize(String s, List<String> wordDict) {
        minlen = 10000;
        maxlen = 1;
        for(String word : wordDict) {
            dictSet.add(word);
            addToLetterArray(word, dictLetters);
            if(word.length() < minlen) {
                minlen = word.length();
            }
            if(word.length() > maxlen) {
                maxlen = word.length();
            }
        }
        System.out.println("min:max = "+minlen+":"+maxlen);
        // for(String word : wordDict) {
        //     dictSet.remove(word);
        //     System.out.println("removed:"+word);
        //     if(!wordBreakHashRec(word, dictSet)) {
        //         dictSet.add(word);
        //         System.out.println("added:" + word);
        //     }
        // }
        System.out.println("Done optimize:"+dictSet);
        if(!letterCheck(s)) return false;
        System.out.println("LetterCheck passed.");
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
            if(!wordBreakHashRec(word, dictSet,0)) {
                dictSet.add(word);
            }
        }
        System.out.println(dictSet);
        if(!letterCheck(s)) return false;
        return wordBreakHashRec(s, dictSet, 0);
    }
    
    public boolean wordBreakHashRec(String s, Set dictSet, int startInd) {
        if(soln[startInd]==-1) return false;
        if(soln[startInd]==1) return true;
        //System.out.println("checking string " + s);
        if(s.length() < minlen) {
            return false;
        }
        for(int i=maxlen; i > 0 && i >= minlen; i--) {
            if(s.length() < i) {
                continue;
            }
            //System.out.println("checking string " + s.substring(0,i));
            if(dictSet.contains(s.substring(0,i))) {
                if(i==s.length()) {
                    soln[startInd] = 1;
                    return true;
                } else {
                    if(wordBreakHashRec(s.substring(i), dictSet, i)) {
                        soln[startInd] = 1;
                        return true;
                    }
                }
            }
        }
        soln[startInd] = -1;
        return false;
    }
    
    public void addToLetterArray(String s, int[] letterArray) {
        for(int i=0; i< s.length(); i++ ) {
            letterArray[s.charAt(i)-'a'] = 1;
        }
    }
    
    // all letters in the word must exist in dictionary letters.
    public boolean letterCheck(String s) {
        System.out.println("dictLetters="+dictLetters);
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
