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
                    ans = ans + ((int) Math.pow(3, 2*parens));
                    // ans = ans + (1 << parens);
                }
            }
        }
        return ans;
        
    }
}

/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:
() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 9 * A, where A is a balanced parentheses string.
 
Example 1:
Input: "()"
Output: 1

Example 2:
Input: "(())"
Output: 9

Example 3:
Input: "()()"
Output: 2

Example 4:
Input: "(()(()))"
Output: 90

Example 5:
Input: "((())())"
Output: 90

*/
