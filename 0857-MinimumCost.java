class Solution {
    
    int k = 0; // number of people to hire
    int totp = 0; // number of people
    
    int[] wage;
    int[] quality;
    double minWage = Double.MAX_VALUE;
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        k = K;
        totp = wage.length;
        this.wage = wage;
        this.quality = quality;
        
        int[] worker = new int[k];
        for(int i =0; i< K) {
            worker[i] = i;
        }
        
        int 
        
        // get first combo of workers
        
        // track ratio needed for equilibrium
        // sort workers by lowest wage/quality ratio
        
        // compare new worker
        // if a lower or equal ratio can be achieved, and qualWage is better than worst worker
        
        // get every combination of workers
        getCombo(0, new ArrayList<Integer>(), 1);
        
        // return the lowest wage.
        return minWage;
        
        
    }
    
    private void getCombo(int index, ArrayList<Integer> combo, int p) {
        for(int i = index; i < totp; i++) {
            combo.add(i);
            if(p==k) {
                double wage = minWage(combo);
                if(minWage > wage) {
                    minWage = wage;
                }
            } else {
                getCombo(i+1, combo, p+1);
            }
            combo.remove(combo.size() - 1);
        }
    }
    
    private ArrayList<Integer> copy(List<Integer> source) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(Integer i : source) {
            newList.add(i);
        }
        return newList;
    }
    
    private double minWage(ArrayList<Integer> combo) {
        System.out.println("testing combo "+ combo);
        boolean minWageFound = false;
        double minWage = 0d;
        double ratio;

        int init = combo.get(0).intValue();
        int i;
        ratio = 1d * wage[init] / quality[init];
        // test the ratio
        for(int index = 0; index < combo.size(); index++) {
            i = combo.get(index).intValue();
            if( Math.round(ratio * quality[i] * 100000) / 100000 < 1d * wage[i]) {
                System.out.println("Starting over: " + ratio * quality[i] + " vs " + 1d * wage[i]);
                ratio = 1d * wage[i] / quality[i];
                index = -1; // start over...
                minWage = 0d;
            } else {
                minWage = minWage + (ratio * quality[i]);
                System.out.println("minWage="+ minWage);
                if(minWage > this.minWage) {
                    break;
                }
            }
        }
        System.out.println("combo, ratio, wage:" + combo + "," + ratio + "," + minWage);
        return minWage;
    }
    
    
    private class Worker() implements Comparable<Worker> {
        int index;
        int minRatio;
        int minRealWage;
        
        public int compareTo(Worker other) {
            
        }
    }
    
}
