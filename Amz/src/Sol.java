
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Sol {

	/*
	 * Given an array of integers, return indices of the two numbers 
	 * such that they add up to a specific target.
	 * Example
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 *
	 * Given nums = [2, 7, 2, 15], target = 9,
	 * return {[0, 1] [1, 2]}
   2-> List(0,2)
	 */

	public static void main(String[] args) {
		int[] nums = {2,7,2,11,15};
		int target = 9;
		//    Set<Integer> indexes = getIndexes(nums,target);
		Set<List<Integer>> indexes = getIndexes(nums,target);
		for(List<Integer> indexList : indexes){
			System.out.print("[");
			for(Integer index : indexList){
				System.out.print(index + " ");
			}
			System.out.print("]");
		}

	}

	public static Set<List<Integer>> getIndexes(int[] A, int target){
		Set<List<Integer>> indexes = new HashSet<List<Integer>>(); 
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i< A.length; i++){
			if(map.get(A[i]) != null){
				List<Integer> list = map.get(A[i]);
				list.add(i);
				map.put(A[i], list); 
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(A[i], list);
			}
			//map.put(A[i], i);
		}

		for(Entry<Integer, List<Integer>> entry : map.entrySet()){
			int key = entry.getKey();
			List<Integer> index1 = entry.getValue();
			int check = target - key;
			if(map.get(check) != null){
				List<Integer> index2 = map.get(check);
				for(Integer i : index1){
					for(Integer j : index2){
						List<Integer> setList = new ArrayList<Integer>();
						setList.add(i);
						setList.add(j);
						indexes.add(setList);
					}
				}
				//indexes.add(index);
				//indexes.add(map.get(check));
			}
		}
		return indexes;
	}

}
