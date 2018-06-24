class Solution {
    
    int x = -1; // -1 is left, 1 is right
    int y = 0;
    int yDir = 1; // -1 is down, 1 is up;
    public int mirrorReflection(int p, int q) {
        System.out.println("Starting:"+p+","+q);
        if(p==0) {
            return 0;
        }
        if(q>p) {
            return 0;
        }
        if(q==0) {
            return 0;
        } else if(q==p) {
            return 1;
        }
        while(true) {
            x = x*-1;
            y = y + (q * yDir);
            if(y > p && yDir==1) {
                yDir = -1;
                y = p - (y % p);
            } else if(y < 0 && yDir==-1) {
                yDir = 1;
                y = 0 + -1 * (y % p);
            }

            System.out.println("x,y,yDir:"+x+","+y+","+yDir);
            
            if(x==-1 && y == p) {
                return 2;
            } else if(x==1) {
                if (y == p) {
                    return 1;
                } else if(y==0) {
                    return 0;
                }
            }
        }
    }
}
