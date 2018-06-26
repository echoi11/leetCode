class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<String>();
        for(int i=0; i < tokens.length; i++ ) {
            st.push(tokens[i]);    
        }

        int res = eval(st);
        return res;
    }
        
    private int eval(Stack<String> st) {
        if(st.isEmpty()) {
            return 0; // ???
        }
        String op;

        op = st.pop(); // *
        if(op.equals("+")) {
            return eval(st) + eval(st); // 3 + 1 = 4
        } else if(op.equals("*")) {
            return eval(st) * eval(st); // 4 * 2
        } else if(op.equals("/")) {
            int op1 = eval(st);
            int op2 = eval(st);
            return op2 / op1;
        } else if(op.equals("-")) {
            int op1 = eval(st);
            int op2 = eval(st);
            return op2 - op1;
        } else { // must be number
            return Integer.valueOf(op); // error handling if not a number
        }
        
    }
}
