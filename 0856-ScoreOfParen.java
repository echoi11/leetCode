class Solution {
    
    int parens=0;
    int ans = 0;
    
    
    public int scoreOfParentheses(String S) {
        
        if(S==null || S.equals("")) {
            return 0;
        }

        for(int i=0; i < S.length(); i++) {
            if(S.charAt(i)=='(') {
                parens++;
            } else {
                parens--;
                if(S.charAt(i-1)=='(') {
                    ans = ans + ((int) Math.pow(2, parens));
                    // ans = ans + (1 << parens);
                }
            }
        }
        return ans;
        
    }
}
