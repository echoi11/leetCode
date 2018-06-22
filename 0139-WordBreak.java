class Solution {
    
    // int[] wordLetters = new int[26];
    int[] soln; 
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // test input
        //s= "catsandog";
        //wordDict = Arrays.asList(new String[]{"cats","dog","sand","and","cat"});
        
        soln = new int[s.length()];
        return wordBreakRec(s, wordDict, 0);
    }
    
    public boolean wordBreakRec(String s, List<String> wordDict, int i) {
        if(soln[i]==-1) return false;
        if(soln[i]==1) return true;
        boolean canBreak = false;
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                if(s.length() == word.length()) {
                    soln[i]=1;
                    return true;
                } else {
                    if(wordBreakRec(s.substring(word.length()), wordDict, word.length())) {
                        soln[i]=1;
                        return true;
                    }
                }
            }
        }
        soln[i]=-1;
        return false;
    }

}
