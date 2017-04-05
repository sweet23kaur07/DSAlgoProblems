package com.amazon.snake.and.ladder;

import java.util.*;

class Solution {
	
	private static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
	
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int val = sol.solution();
		System.out.println(val);
	}
    
    class Jump {
        int position;
        int counter;
        Jump(int position, int counter) {
            this.position = position;
            this.counter = counter;
        }
    }
    
    public void fillladder(){
    	ladder.put(2, 13);
    	ladder.put(12, 21);
//    	ladder.put(1, 25);
    	
    }
    public void fillSnakes(){
    	snakes.put(25, 3);
    	ladder.put(16, 7);
    	
    }
    
    public int solution() {
        fillladder();
        fillSnakes();
        
        boolean[] accessed = new boolean[55]; 
        List<Jump> jumps = new ArrayList<Jump>();
        jumps.add(new Jump(-1, 0));
        Jump cj = null;
        int step = 0;
        while(true) {
            if(step==jumps.size()) {
                return -1;
            }
            cj = jumps.get(step);
            step++;
            for(int i = 1; i <= 6 ; i++) {
            	if(cj.position==25) {
                    return cj.counter;
                }
                if(cj.position+i==25) {
                    return cj.counter+1;
                } else if((cj.position+i) < 25 && accessed[cj.position+i]) {
                    continue;
                }else if(ladder.get(cj.position+i) != null){
                	jumps.add(new Jump(ladder.get(cj.position+i), cj.counter+1));
                	accessed[ladder.get(cj.position+i)] = true;
                }else if(snakes.get(cj.position+i) != null){
                	jumps.add(new Jump(snakes.get(cj.position+i), cj.counter+1));
                	accessed[snakes.get(cj.position+i)] = true;
                }else{
                	jumps.add(new Jump(cj.position+i, cj.counter+1));
                	accessed[cj.position+i] = true;
                }
            }
        }
    }
    
}