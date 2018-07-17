class ExamRoom {

	int[] seats;

	// Set of open seats, sorted by min dist, then by start index.
	TreeSet<Section> ts = new TreeSet<Section>(Collections.reverseOrder());
	// number of Seats
	int seated = 0;
	int numOfSeats;

	public ExamRoom(int N) {
		numOfSeats = N;
		seats = new int[N];
	}

	public int seat() {
		int seatNumber;
		if (seated == 0) {
			seatNumber = 0;
			seats[seatNumber] = 1;
			Section sec = new Section(0, numOfSeats - 1);
			ts.add(sec);
		} else {
			Section sec = ts.first();
            System.out.println("got sec from ts: " + sec.toString());
			System.out.println("remove:"+ts.remove(sec));
			seatNumber = sec.start + sec.seatOffset;
			if(sec.seatOffset==0 || sec.seatOffset==(sec.end - sec.start)) {
				seats[seatNumber] = 1;
				sec = new Section(sec.start, sec.end);
				ts.add(sec);
			} else {
				// split the section
				seats[seatNumber] = 1;
				Section sec1 = new Section(sec.start, seatNumber);
				ts.add(sec1);
				sec1 = new Section(seatNumber, sec.end);
				ts.add(sec1);
			}
		}
		seated++;
		return seatNumber;
	}

	public void leave(int p) {
		int start = 0;
		int end = 0;

		Section sec1 = null;

		for(Section sec : ts) {
			if(sec.end==p) {
				start = sec.start;
				end = sec.end;
				sec1 = sec;
			}
		}
		if(sec1!=null) {
            ts.remove(sec1);
            System.out.println("removed: " + sec1);
        }
		for(Section sec : ts) {
			if(sec.start == p) {
				end = sec.end;
				sec1 = sec;
			}
		}
		if(sec1!=null) {
            ts.remove(sec1);
            System.out.println("removed: " + sec1);
        }
		seats[p]=0;
		seated--;
		ts.add(new Section(start, end));
	}

	private class Section implements Comparable<Section> {
		int start;
		int end;
		int dist; // mininum distance
		int seatOffset; // index offset for next seat.

		public Section(int start, int end) {
			this.start = start;
			this.end = end;
			if (start == 0 && seats[0] == 0) {
				seatOffset = 0;
				dist = end;
			} else if (end == numOfSeats - 1 && seats[end] == 0) {
				seatOffset = end - start;
				dist = seatOffset - 1;
			} else {
				dist = ((end - start) / 2) - 1;
				seatOffset = (end - start) / 2;
			}
            System.out.println("new section: " + toString());
		}

        public String toString() {
            System.out.println("seated=" + seated);
            System.out.println("seats=" + Arrays.toString(seats));
            return start + "," + seatOffset + "," + end + "," + dist;
        }
        
		public int compareTo(Section other) {
			if (this.dist > other.dist) {
				return 1;
			} else if (this.dist == other.dist) {
				if (this.start < other.start) {
					return 1;
                } else if (this.start==other.start) {
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
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
