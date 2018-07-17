class ExamRoom {

   	HashSet<Integer> seats;

	// Set of open seats, sorted by min dist, then by start index.
	TreeSet<Section> ts = new TreeSet<Section>(Collections.reverseOrder());
	// number of Seats
	int seated = 0;
	int numOfSeats;

	public ExamRoom(int N) {
		numOfSeats = N;
		seats = new HashSet<Integer>();
	}

	public int seat() {
		int seatNumber;
		if (seated == 0) {
//				System.out.println("all seats are empty. sit down at 0...");
			seatNumber = 0;
			seats.add(seatNumber);
			Section sec = new Section(0, numOfSeats - 1);
//				System.out.println("Adding section: " + sec);
			ts.add(sec);
		} else {
			Section sec = ts.first();
//	            System.out.println("Sit down at ...");
//	            System.out.println("got sec from ts: " + sec.toString());
			if (!ts.remove(sec)) {
//	    			System.out.println("remove failed!!!");
			}
			seatNumber = sec.start + sec.seatOffset;
			if (sec.seatOffset == 0 || sec.seatOffset == (sec.end - sec.start)) {
				seats.add(seatNumber);
				sec = new Section(sec.start, sec.end);
//					System.out.println("Adding section: " + sec);
				ts.add(sec);
			} else {
				// split the section
				seats.add(seatNumber);
				Section sec1 = new Section(sec.start, seatNumber);
//					System.out.println("Adding section1: " + sec1);
				ts.add(sec1);
				sec1 = new Section(seatNumber, sec.end);
//					System.out.println("Adding section2: " + sec1);
				ts.add(sec1);
			}
		}
		seated++;
//			System.out.println("seated=" + seated);
//			System.out.println("seats=" + Arrays.toString(seats));
		return seatNumber;
	}

	public void leave(int p) {
//			System.out.println("Leaving seat " + p);
		int start = 0;
		int end = 0;

		Section sec1 = null;

		for (Section sec : ts) {
			if (sec.end == p) {
				start = sec.start;
				end = sec.end;
				sec1 = sec;
			}
		}
		if (sec1 != null) {
			ts.remove(sec1);
//	            System.out.println("removed: " + sec1);
		}
		for (Section sec : ts) {
			if (sec.start == p) {
				end = sec.end;
				sec1 = sec;
			}
		}
		if (sec1 != null) {
			ts.remove(sec1);
//	            System.out.println("removed: " + sec1);
		}
		seats.remove(p);
		seated--;
		if (seated == 0) {
			ts.clear();
		} else {
			sec1 = new Section(start, end);
//				System.out.println("Adding section: " + sec1);
			ts.add(sec1);
		}
	}

	private class Section implements Comparable<Section> {
		int start;
		int end;
		int dist; // mininum distance
		int seatOffset; // index offset for next seat.

		public Section(int start, int end) {
			this.start = start;
			this.end = end;
			if (start == 0 && !seats.contains(0)) {
				seatOffset = 0;
				if (seats.contains(end)) {
					dist = end - 1;
				} else {
					dist = end;
				}
			} else if (end == numOfSeats - 1 && !seats.contains(end)) {
				seatOffset = end - start;
				dist = seatOffset - 1;
			} else {
				dist = ((end - start) / 2) - 1;
				seatOffset = (end - start) / 2;
			}
//	            System.out.println("new section: " + toString());
		}

		public String toString() {
//	            System.out.println("seated=" + seated);
//	            System.out.println("seats=" + Arrays.toString(seats));
			return start + "," + seatOffset + "," + end + "," + dist;
		}

		public int compareTo(Section other) {
			if (this.dist > other.dist) {
				return 1;
			} else if (this.dist == other.dist) {
				if (this.start < other.start) {
					return 1;
				} else if (this.start == other.start) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}



}

/**
["ExamRoom","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave"]
[[1000000000],[],[0],[],[0],[],[0],[],[0],[],[0]]
["ExamRoom","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave"]
[[1000000],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0],[],[0]]
["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat"]
[[8],[],[],[],[0],[7],[],[],[],[],[],[],[]]
["ExamRoom","seat","seat","seat","seat","leave","seat"]
[[10],[],[],[],[],[4],[]]
["ExamRoom","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave"]
[[10],[],[],[0],[9],[],[],[],[],[],[],[],[],[],[],[0]]
**/



/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
