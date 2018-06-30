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
        //System.out.println("comparing=" + s);
        int len = s.length();
        // System.out.println(s.substring(0, len/2));
        // System.out.println(s.substring(len/2 + len%2));
        // if(len < 2 || s.substring(0, len/2).equals(s.substring(len/2 + len%2))) {
        //     mem.add(s);
        //     return true;
        // } else {
        //     return false;
        // }
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0; i< (s.length()/2); i++) {
            // System.out.println(i);
            // System.out.println(s.length()-i);
            // if(mem.contains(s.substring(i,len-i))) {
            //     return true;
            // } else {
            //     temp.add(s.substring(i,len-i));
            // }
            if(s.charAt(i)!=s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        // mem.addAll(temp);
        mem.add(s);
        return true;
    }
}
