class ExamRoom {

    // start, end indexes, inclusive and seat offset
   // int[][] seats; //= int [N][3]
    
    int[] seats;

    // min dist to next student
    // Set of open seats, sorted by min dist, then by start index.
    TreeSet<OpenSection> ts = new TreeSet<OpenSection>();
    // number of Seats
    int seated = 0;
//    int maxDist;
//    int maxSeat;
    int numOfSeats;
    
    public ExamRoom(int N) {
        numOfSeats = N;
        seats = new seats[N];
    }
    
    public int seat() {
        if(seated==0) {
            OpenSection os = new OpenSection(0, N-1);
            ts.add(os);
            seated_++;
            seats[0][0] = 0;
            seats[0][1] = (N-1) *2;
            maxDist = seats[0][1];
            maxSeat = 0;
        } else {
            
            while(true) {
                if(seats[i][0] == maxDist) { // know maxDist => know maxDist seat too!
                    sitdown(i, maxDist, true); // todo
                } else if(seats[i][1] == maxDist ) {
                    sitRight(i, maxDist, false);
                }
            }
        }
        seated++;
    }
    
    private void sitdown(int neighbor, int dist, boolean isLeft) {
        if(seats[maxSeat][0] != 0) {
            // always sit on left side unless first seat
            int offset = dist/2 + dist % 2;
            seats[maxSeat - offset][0] = Math.min(maxSeat, dist/2);
            seats[maxSeat - offset][1] = dist/2;
        } else {
            // sit right
            int offset = dist/2;
            seats[maxSeat - offset][0] = dist/2;
            seats[maxSeat - offset][1] = Math.min(maxSeat + 1 - N , dist/2);
        }
        // adjust neighbors;
        int newSeat = maxSeat - offset;
        seats[newSeat - dist/2][1] = seats[newSeat][0];
        if(seats[newSeat + dist/2][0] > 0) {
            seats[newSeat + dist/2][0] = seats[newSeat][1];
        } else {
            seats[newSeat + dist/2 + 1][0] = seats[newSeat][1];
        }
        findMaxDist();
    }
    
    private findMaxDist() {
        maxDist = -1;
        for(int i=0; i < seats.size; i++) {
            if(seats[i][0] > maxDist) {
                maxDist = seats[i][0];
                maxSeat = i;
            } else if(seats[i][1] > maxDist) {
                maxDist = seats[i][1];
                maxSeat = i;
            }
        }
    }
    
    public void leave(int p) {
        seats[p] = 0;
        // adjust neighbors
        
    }

    private class OpenSection() {
        int start;
        int end;
        int dist; // mininum distance
        int seatOffset; // index offset for next seat.
        
        public OpenSection(int start, int end) {
            this.start = start;
            this.end = end;
            if(start==0 && seat[0]==0) {
                seatOffset = 0;
                dist = end - start - 1;
            } else if(end==numOfSeats-1 && seat[end]==0) {
                seatOffset = end - start;
                dist = end - start - 1;
            } else {
                dist = (end - start - 1) / 2;
                seatOffset = (end - start)/2;
            }
            
        }
    }

}



/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
