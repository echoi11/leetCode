class Solution {
    // [1,0,0,0,1,0,1]
    // [1,0,0,0]
    public int maxDistToClosest(int[] seats) {
        boolean left = false; // if false, then dist = num of 0's
        boolean right = false; // else dist = num of 0's + 1 / 2
        int numZ = 0;
        int dist = 0;
        int result = 0;
        for(int i=0; i < seats.length; i++) {
            if(seats[i]==1) {
                if(numZ > 0) {
                    right = true;
                    if(left && right) {
                        dist = (numZ+1)/2;
                    } else {
                        dist = numZ;
                    }
                    left = true;
                    right = false;
                    numZ=0;
                } else {
                    left = true;
                    right = false;
                }
            } else {
                numZ++;
                if(i==seats.length-1) {
                    dist = numZ;
                }
            }
            result = Math.max(result, dist);
        }
        return result;
    }
}
