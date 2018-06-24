class Solution {
    
    String S;
    StringBuilder exp = new StringBuilder("");
    
    String res;

    ArrayList <Node>l = new ArrayList<Node>();
    
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
        
        
        Node root = new Node();
        Node res = root;
        Node p = res;
        for(int i=0; i < S.length()-1; i++) {
            if(S.charAt(i) == '(') {
                if(S.charAt(i+1) =='(') {   // ((
                    exp.append("2*(");
                    p.value = 2;
                    res = new Node();
                    p.mult = res;
                    res.prev = p;
                    p = res;
                } else {                    // ()
                    exp.append("1");
                    p.value = 1;
                }
            } else { // )
                if(S.charAt(i+1)=='(') {    // )(
                    exp.append("+");
                    res = new Node();
                    p.add = res;
                    res.prev = p.prev;
                    p = res;
                } else { // ))
                    exp.append(")");
                    p = p.prev;
                }
            }
        }

        result = eval(root);
        
        return result;
        
    }
    
    private int eval(Node n) {
        if(n.mult!=null) {
            n.value = n.value * eval(n.mult);
        }
        if(n.add!=null) {
            n.value = n.value + eval(n.add);
        }
        return n.value;
    }
    
    private class Node {
        Node prev;
        Node mult; // for *
        Node add; // for *
        int value;
        
        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
