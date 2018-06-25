class Solution {
    
    TreeSet<Fleet> ft = new TreeSet<Fleet>();
    TreeSet<Fleet> ft2 = new TreeSet<Fleet>();
    int numOfFleet = 0;
    
    
    public int carFleet(int target, int[] position, int[] speed) {
        if(target==0 || position==null || position.length==0
          || speed ==null || speed.length==0) {
            return numOfFleet;
        }
        for(int i=0; i < position.length; i++) {
            ft.add(new Fleet(position[i], speed[i]));
        }
        
        double ttt = 0d;
        int fnum = 0;
        int prevPosition=0;
        
        int minSpeed;
        boolean canMerge;
        
        while(true) {
            ttt = 0d;
            fnum = 0;
            prevPosition=0;
            ft2 = new TreeSet<Fleet>();
            minSpeed=0;
            canMerge = false;
            for(Fleet f : ft) {
                //System.out.println(fnum + ":" + f);

                //System.out.println("minspeed:"+minSpeed);
                if(fnum==0) {
                    minSpeed = f.speed;
                } else {
                    if(f.speed > minSpeed) {
                        canMerge = true;
                    } else {
                        minSpeed = f.speed;
                    }
                }
                //System.out.println("canMerge:"+canMerge);
                
                if(f.position >= target) { // car has finished
                    // dont move it to new set
                    System.out.println("fleet finished: "+ f);
                    numOfFleet++;
                    prevPosition = -1; // prev car has finished;
                    minSpeed = 0;
                    fnum++;
                    continue;
                }

                if(fnum > 0) {
                    // check if it caught up to prior car
                    if(prevPosition >=0) { // prev car has not reached target;
                        //System.out.println("ttt:"+ttt+"prevPos:"+prevPosition);
                        
                        if((ttt * f.speed) + f.position >= prevPosition) {
                            // merge this one with prior fleet ie dont add to new set
                            //System.out.println("merging with prior fleet: "+ f);
                            fnum++;
                            continue;
                        }
                    }
                }

                if(f.speed + f.position >= target) {
                    ttt = 1d * (target - f.position) / f.speed;
                } else {
                    ttt = 1d;
                }

                f.position = Math.min(target, f.position + f.speed);
                prevPosition = f.position;
                //System.out.println("Adding " + f);
                ft2.add(f);

                fnum++;
            }
            if(!canMerge) {
                numOfFleet += ft2.size();
                break;
            }
            if(ft2.isEmpty()) {
                break;
            }
            ft = ft2;
        }
        return numOfFleet;
    }
    
    
    private class Fleet implements Comparable<Fleet> {
        int position;
        int speed;
        
        public Fleet(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
        
        public int compareTo(Fleet other) {
//            if(this.position == other.position) return 0;
            if(this.position < other.position) return 1;
            return -1;
        }
        
        public String toString() {
            return position +","+speed;
        }
    }
    
    
}
