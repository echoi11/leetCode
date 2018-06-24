class Solution {
    
    String S;
    StringBuilder exp = new StringBuilder("");
    
    String res;

    ArrayList l = new ArrayList();
    
    int result = 0;
    int tempResult = 0;
    
    public int scoreOfParentheses(String S) {
        this.S = S;
        if(S==null || S.length()==0) {
            return 0;
        }
        for(int i=0; i < S.length()-1; i++) {
            if(S.charAt(i) == '(') {
                if(S.charAt(i+1) =='(') {   // ((
                    exp.append("2*(");
                } else {                    // ()
                    exp.append("1");
                }
            } else { // )
                if(S.charAt(i+1)=='(') {
                    exp.append("+");
                } else { // ))
                    exp.append(")");
                }
            }
        }
        System.out.println(exp);
        
//        exp = new StringBuilder("");
        res = exp.toString();
//        result = eval(0);
        System.out.println(exp);
        
        return result;
        
    }
    
//     private int eval(int i) {
//         if(i == res.length()) { // todo
//             exp.append(0); // todo
//             return 0;   // todo
//         }
        
//         char c = res.charAt(i);
        
//         if(c == '(') {
//             return eval(i+1);
//         } else if(c == '2') {
//             return 2 * eval(i+2);
//         } else if(c == '1') {
//             return 1;
//         } else if(c == ')') {
//             // ???
//         }
//     }

    // "(())()"
         // 2*(1)+1
         // 2*(1+0
//     "(())"
// "()()"
// "(()(()))"
// "(())()"
// "((()))"
    
}
