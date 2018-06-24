class Solution {
    
    int[] fleet;
    
    public int carFleet(int target, int[] position, int[] speed) {
        if(position==null || position.length==0) {
            return 0;
        }
        // sort the list
        int temp;
        for(int j = 0; j < position.length; j ++ ) {
            for(int i = 0 ; i < position.length - 1; i++) {
                if(position[i] < position[i+1]) {
                    swap(position, i, i+1);
                    swap(speed, i, i+1);
                }
//                System.out.println("position=" + Arrays.toString(position));
            }
        }
        
        initFleet(position.length);
        System.out.println("init position=" + Arrays.toString(position));
        System.out.println("init speed   =" + Arrays.toString(speed));
        
        int cycles = target;
        while(cycles > 0) {
            for(int i = 0; i < position.length - 1; i ++ ) {
                if(position[i]<=target && position[i]==position[i+1]) {
                    // combine fleets if two cars are at same position but not past destination
                    if(fleet[i] != fleet[i+1]) {
                        fleet[i+1] = fleet[i];
                        speed[i+1] = speed[i];
                        // numOfFleet--;
                    }
                }
            }
            System.out.println("revised fleet =" + Arrays.toString(fleet));
            System.out.println("position      =" + Arrays.toString(position));

            double [] timeToTarget= new double[fleet.length];
            for(int i = 0; i < position.length; i ++ ) {
                //System.out.println(i+":pos, speed:" + position[i] + ","+speed[i]);
                if((position[i] < target) && (position[i]+ speed[i] >=target)) {
                    timeToTarget[i] = 1d * (target - position[i]) / speed[i]; // 0 < n < =1
                } else {
                    //System.out.println((position[i] < target) + "");
                    //System.out.println((position[i] + speed[i] >= target) + "");
                    timeToTarget[i] =0;
                }
                //System.out.println("ttt="+ timeToTarget[i]);
                if(i==0) {
                    position[0] += speed[0];
                } else {
                    if(timeToTarget[i-1] > 0d) { // can this car reach target in time?
                        //System.out.println("timeToTarget check..." + i);
                        //System.out.println(""+(speed[i] * timeToTarget[i-1] >= (target - position[i])));
                        if(speed[i] * timeToTarget[i-1] >= (target - position[i])) {
                            int iToMerge = i;
                            int thisFleet = fleet[i];
                            int targetFleet = fleet[i-1];
                            while(iToMerge < fleet.length) {
                                if(fleet[iToMerge] == thisFleet) {
                                    fleet[iToMerge] = targetFleet;
                                    iToMerge++;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            timeToTarget[i-1] =0;
                        }
                    }
                    position[i] = Math.min(position[i] + speed[i], position[i-1]);
                }
            }
            cycles--;
            System.out.println("position after=" + Arrays.toString(position));
        }
        
        return numOfFleet();
        
    }
    
    private void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
        
    private void initFleet(int size) {
        // numOfFleet = size;
        // finished = new int[size];
        fleet = new int[size];
        for(int i=0; i < size; i++) {
            fleet[i]=i;
        }
    }
    
    private int numOfFleet() {
        int num = 1;
        for(int i = 0; i < fleet.length - 1; i ++ ) {
            if(fleet[i]!=fleet[i+1]) {
                num++;
            }
        }
        return num;
    }
    
}
