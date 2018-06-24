class Solution {
    
    int[] fleet;
    // int numOfFleet=0;
    
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
        System.out.println("position=" + Arrays.toString(position));
        System.out.println("speed   =" + Arrays.toString(speed));
        
        int cycles = target;
        while(cycles >0 ) {
            for(int i = 0; i < position.length - 1; i ++ ) {
                if(position[i]<=target && position[i]==position[i+1]) {
                    if(fleet[i] != fleet[i+1]) {
                        fleet[i+1] = fleet[i];
                        speed[i+1] = speed[i];
                        // numOfFleet--;
                    }
                }
            }
            System.out.println("position=" + Arrays.toString(position));
            System.out.println("fleet=" + Arrays.toString(fleet));

            position[0] += speed[0];
            for(int i = 0; i < position.length - 1; i ++ ) {
                position[i+1] = Math.min(position[i+1] + speed[i+1], position[i]);
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
