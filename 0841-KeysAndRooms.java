class Solution {
    Stack<Integer> s = new Stack<Integer>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size()==1) return true;
        boolean [] keys = new boolean [rooms.size()];
        int visitedRooms = 1;
        keys[0] = true;
        int i=0;
        for(int key : rooms.get(i)) {
            s.push(key);
        }
        if(s.isEmpty()) return false;
        do {
            int skey = s.pop();
            if(!keys[skey]) {
                keys[skey]= true;
                visitedRooms++;
                for(int key : rooms.get(skey)) {
                    s.push(key);
                } 
            }
        } while(visitedRooms < rooms.size() && !s.isEmpty());
        if(visitedRooms == rooms.size()) return true;
        else return false;
    }

}
