class Solution {
    HashSet<String> mem = new HashSet<String>();
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        for(int i=0; i < words.length; i++) {
            for(int j=0; j< words.length; j++) {
                if((words[i].length()==0 || words[j].length()==0 || words[i].charAt(0)==words[j].charAt(words[j].length()-1))
                        && i != j) {
                    if( isPalindrome(words[i] + words[j])) {
                        if(words[i].length() == words[j].length()) {
                            mem.add(words[j]+words[i]);
                        }
                        List<Integer> subL = new ArrayList<Integer>();
                        subL.add(i); subL.add(j);
                        sol.add(subL);
                    }
                }
            }
        }
        return sol;
    }
                   
    private boolean isPalindrome(String s) {
        if(mem.contains(s)) return true;
        int len = s.length();
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0; i< (s.length()/2); i++) {
            if(s.charAt(i)!=s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        mem.add(s);
        return true;
    }
}
