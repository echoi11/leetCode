class ExamRoom {

//    ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//    [null,0,9,4,2,null,5]
    
//    ["ExamRoom","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave"]
//    [[1000000000],[],[0],[],[0],[],[0],[],[0],[],[0]]
    int numOfSeats = 0;
    int numOfSeated = 0;
    int [] seats;
    
    public ExamRoom(int N) {
        numOfSeats = N;
        numOfSeated = 0;
        seats = new int[N];
    }
    
    public int seat() {
        if(numOfSeated ==0) {
            seats[0] = 1;
            numOfSeated++;
            return 0;
        } else {
            int seat = findSeat();
            numOfSeated++;
            seats[seat] = 1;
            return seat;
        }
    }
    
    private int findSeat() {
        boolean left = false;
        boolean right = false;
        int dist = 0;
        int emptySeats = 0;
        int maxDist = 0;
        int maxIndex = 0;
        int index = 0;
        for(int i=0; i < numOfSeats; i++) {
            if(seats[i]==1) {
                if(emptySeats > 0) {
                    if(left==true) {
                        dist = (emptySeats+1)/2;
                        if(dist > maxDist) {
                            maxDist = dist;
                            maxIndex = i - ((emptySeats/2) +1);
                        }
                    } else {
                        dist = emptySeats;
                        if(dist > maxDist) {
                            maxDist = dist;
                            maxIndex = 0;
                        }
                    }
                    emptySeats = 0;
                    left = true;
                    right = false;
                } else {
                    left = true;
                }
            } else {
                emptySeats++;
                if(i==numOfSeats - 1) {
                    if(emptySeats > maxDist) {
                        maxDist = emptySeats;
                        maxIndex = numOfSeats - 1;
                    }
                }
            }
        }
        return maxIndex;
    }
    
    public void leave(int p) {
        seats[p] = 0;
        numOfSeated--;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
