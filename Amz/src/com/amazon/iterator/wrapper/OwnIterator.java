package com.amazon.iterator.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class OwnIterator {
	
	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list1.add("RAT");
		list1.add("CAT");
		list1.add("BAT");
		list1.add("RAT");
		
		list2.add("MAT");
		list2.add("RAT");
		list2.add("CAT");
		list2.add("RAT");
		list2.add("MAT");
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		Iterator<String> itr1 = list1.iterator();
		Iterator<String> itr2 = list2.iterator();
		
		ResultIterator<String> itr = new ResultIterator(itr1, itr2);
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	

}

class ResultIterator <E extends Comparable<E>> {
    private Iterator<E> itr1;
    private Iterator<E> itr2;
    private E savedNext = null;
    private int itrNo = 0;

    ResultIterator(Iterator<E> itr1, Iterator<E> itr2) {
        this.itr1 = itr1;
        this.itr2 = itr2;
    }

    public boolean hasNext() {
        return itr1.hasNext() || itr2.hasNext() || savedNext != null;
    }
    
    public E next() {
    	if(savedNext != null && itrNo != 0){
    		E nextItr = itrNo == 1 ? itr2.next() : itr1.next();
    		int cmp = nextItr.compareTo(savedNext);
    		
    		if(cmp == 0){
    			savedNext = null;
    			itrNo = 0;
    			return nextItr;
    		} else if(cmp < 0){
    			
    			return nextItr;
    		} else {
    			itrNo = 0;
    			return savedNext;
    		}
    	}
    	
    	if(itr1.hasNext() && itr2.hasNext()){
    		 E nextItr1 = itr1.next();
             E nextItr2 = itr2.next();
             int cmp = nextItr1.compareTo(nextItr2);

             if (cmp == 0) {
            	 return nextItr1;
             } else if (cmp > 0) {
                 savedNext = nextItr1;
                 itrNo = 1;
                 return nextItr2;
             } else{
            	 savedNext = nextItr2;
                 itrNo = 2;
                 return nextItr1;
             }
    	}
    	
    	if(itr1.hasNext()){
    		return itr1.next();
    	}
    	
    	return itr2.next();
    	
    }
}
