class Solution {
    
    int dec =0;
    int exp =0;
    
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.startsWith("-")) {
            s = s.substring(1);
        }
        if(s.startsWith("+")) {
            s = s.substring(1);
        }
        if(s.startsWith(".e")) {
            return false;
        }
        if(s.endsWith("e.")) {
            return false;
        }
        if(s.length()==0) {
            return false;
        }
        char c;
        for(int i=0; i < s.length(); i++) {
            c = s.charAt(i);
            if( c < '0' || c > '9') {
                if(c=='.') {
                    if(s.length()==1) {
                        return false;
                    }
                    if(exp > 0) {
                        return false;
                    }
                    dec++;
                    if(dec > 1) {
                        return false;
                    }
                } else if(c=='e') {
                    if(i==0 || i ==(s.length()-1)) {
                        return false;
                    }
                    exp++;
                    if(exp > 1) {
                        return false;
                    }
                } else if(c=='+' || c=='-') {
                    if(i > 0 && s.charAt(i-1)=='e') {
                        if(i==(s.length()-1)) {
                            return false;
                        } else {
                            continue;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
