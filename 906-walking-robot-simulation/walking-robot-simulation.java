class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // Store obstacles
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(o[0] + "," + o[1]);
        }
        
        // Directions: N, E, S, W
        int[][] dirs = {
            {0,1}, {1,0}, {0,-1}, {-1,0}
        };
        
        int d = 0; // start facing North
        int x = 0, y = 0;
        int maxDist = 0;
        
        for (int cmd : commands) {
            
            if (cmd == -1) {
                d = (d + 1) % 4; // turn right
            } 
            else if (cmd == -2) {
                d = (d + 3) % 4; // turn left
            } 
            else {
                // move step by step
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    
                    if (obs.contains(nx + "," + ny)) break;
                    
                    x = nx;
                    y = ny;
                    
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        
        return maxDist;
    }
}