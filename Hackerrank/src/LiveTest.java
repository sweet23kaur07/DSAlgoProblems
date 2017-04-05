import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LiveTest {

	public static void main(String[] args) throws ClassNotFoundException{
		Queue<String> queue = new LinkedList<String>();
		queue.add("dwed");
		Stack< Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.pop();
		stack.isEmpty();
		String s = "|bnmsc|dscds|~|dsvcds|dsvd|dscd";
		StringTokenizer token = new StringTokenizer(s);
		String[] array = s.split("\\|~\\|");
		for(String s1 : array){
			System.out.println(s1);
		}
		String[] as = array[0].split("\\|");
		System.out.println("Length " + ((as.length) -1));
		for(String s1 : as){
			System.out.println(s1);
		}
		int[] arr = new int[26];
		String[] str = s.split("|");
		String ss= "Hi Sweet Sweet";
		Map<Integer, Integer> map = new HashMap();
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Integer, Integer>> itr = entrySet.iterator();
		/*while(itr.hasNext()){
			Entry<Integer, Integer> entry = itr.next();
			int key = entry.getKey();
			int val = entry.getValue();
			int v  = no - val;
			if(map.get(v) != null && map.get(v) != 0){
				count++;
			}
		}*/
		
		String strLike = "sweet";
		strLike.contains("ee");

		Class aClass = Class.forName("A");
		Method[] methods = aClass.getMethods();
		for(Method method : methods){
			method.getName();
		}


		StringBuilder builder = new StringBuilder();
		builder.append("sdf");
		int a = 23;
		int i = a/7;


		List<A> aList = new ArrayList<>();
		aList.add(new B());
		List<B> bList = new ArrayList<>();
		List<C> cList = new ArrayList<>();

		insertElementsSpecific(aList);
		processElements(bList);
		insertElements(aList);
	}

	public static void insertElements(List<? super B> list){
		//		list.add(new A());
		list.add(new B());
	}

	public static void insertElementsSpecific(List<A> list){
		list.add(new A());
		list.add(new B());
	}

	public static void processElements(List<? extends A> elements){
		for(Object o : elements){
			System.out.println(o);
		}
	}
}


class A{
	public void firstAPI(){

	}
	public void secondAPI(){

	}

}

class B extends A{

}

class C{

}