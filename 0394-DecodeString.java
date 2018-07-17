class Solution {
/**
"3[abc]"
"3[a]2[bc]"
"3[a2[c]]"
"2[abc]3[cd]ef"
**/

    public String decodeString(String s) {
        char c;
        int num = 0;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        strStack.push(new StringBuilder());
        for(int i=0; i < s.length(); i++) {
            c = s.charAt(i);
            while(c >= '0' && c <='9') {
                num = num * 10;
                num = num + Integer.valueOf(c + "");
                c = s.charAt(++i);
            }
            if(num > 0 && c == '[') {
                numStack.push(num);
                strStack.push(new StringBuilder());
                num = 0;
            } else if(c==']') {
                int j = numStack.pop();
                StringBuilder strPop = strStack.pop();
                StringBuilder str = new StringBuilder();
                while(j > 0) {
                    str.append(strPop);
                    j--;
                }
                strStack.push(strStack.pop().append(str));
            } else {
                strStack.push(strStack.pop().append(c));
            }
        }
        return strStack.toString();
    }
}
