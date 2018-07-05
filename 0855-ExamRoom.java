class ExamRoom {

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
            return 0;
        }
    }
    
    public void leave(int p) {
        seats[p] = 0;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
